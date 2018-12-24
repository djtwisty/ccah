package org.apache.cordova;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.cordova.PluginResult.Status;

public class NativeToJsMessageQueue {
    static final boolean DISABLE_EXEC_CHAINING = false;
    private static final boolean FORCE_ENCODE_USING_EVAL = false;
    private static final String LOG_TAG = "JsMessageQueue";
    private static int MAX_PAYLOAD_SIZE = 524288000;
    private BridgeMode activeBridgeMode;
    private ArrayList<BridgeMode> bridgeModes = new ArrayList();
    private boolean paused;
    private final LinkedList<JsMessage> queue = new LinkedList();

    public static abstract class BridgeMode {
        public abstract void onNativeToJsMessageAvailable(NativeToJsMessageQueue nativeToJsMessageQueue);

        public void notifyOfFlush(NativeToJsMessageQueue nativeToJsMessageQueue, boolean z) {
        }

        public void reset() {
        }
    }

    public static class EvalBridgeMode extends BridgeMode {
        private final CordovaInterface cordova;
        private final CordovaWebViewEngine engine;

        public EvalBridgeMode(CordovaWebViewEngine cordovaWebViewEngine, CordovaInterface cordovaInterface) {
            this.engine = cordovaWebViewEngine;
            this.cordova = cordovaInterface;
        }

        public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue nativeToJsMessageQueue) {
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    String popAndEncodeAsJs = nativeToJsMessageQueue.popAndEncodeAsJs();
                    if (popAndEncodeAsJs != null) {
                        EvalBridgeMode.this.engine.evaluateJavascript(popAndEncodeAsJs, null);
                    }
                }
            });
        }
    }

    private static class JsMessage {
        final String jsPayloadOrCallbackId;
        final PluginResult pluginResult;

        JsMessage(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.jsPayloadOrCallbackId = str;
            this.pluginResult = null;
        }

        JsMessage(PluginResult pluginResult, String str) {
            if (str == null || pluginResult == null) {
                throw new NullPointerException();
            }
            this.jsPayloadOrCallbackId = str;
            this.pluginResult = pluginResult;
        }

        static int calculateEncodedLengthHelper(PluginResult pluginResult) {
            int i = 1;
            switch (pluginResult.getMessageType()) {
                case 1:
                    return pluginResult.getStrMessage().length() + 1;
                case 3:
                    return pluginResult.getMessage().length() + 1;
                case 4:
                case 5:
                    return 1;
                case 6:
                    return pluginResult.getMessage().length() + 1;
                case 7:
                    return pluginResult.getMessage().length() + 1;
                case 8:
                    for (int i2 = 0; i2 < pluginResult.getMultipartMessagesSize(); i2++) {
                        int calculateEncodedLengthHelper = calculateEncodedLengthHelper(pluginResult.getMultipartMessage(i2));
                        i += calculateEncodedLengthHelper + (String.valueOf(calculateEncodedLengthHelper).length() + 1);
                    }
                    return i;
                default:
                    return pluginResult.getMessage().length();
            }
        }

        int calculateEncodedLength() {
            if (this.pluginResult == null) {
                return this.jsPayloadOrCallbackId.length() + 1;
            }
            return ((((String.valueOf(this.pluginResult.getStatus()).length() + 2) + 1) + this.jsPayloadOrCallbackId.length()) + 1) + calculateEncodedLengthHelper(this.pluginResult);
        }

        static void encodeAsMessageHelper(StringBuilder stringBuilder, PluginResult pluginResult) {
            int i = 0;
            switch (pluginResult.getMessageType()) {
                case 1:
                    stringBuilder.append('s');
                    stringBuilder.append(pluginResult.getStrMessage());
                    return;
                case 3:
                    stringBuilder.append('n').append(pluginResult.getMessage());
                    return;
                case 4:
                    stringBuilder.append(pluginResult.getMessage().charAt(0));
                    return;
                case 5:
                    stringBuilder.append('N');
                    return;
                case 6:
                    stringBuilder.append('A');
                    stringBuilder.append(pluginResult.getMessage());
                    return;
                case 7:
                    stringBuilder.append('S');
                    stringBuilder.append(pluginResult.getMessage());
                    return;
                case 8:
                    stringBuilder.append('M');
                    while (i < pluginResult.getMultipartMessagesSize()) {
                        PluginResult multipartMessage = pluginResult.getMultipartMessage(i);
                        stringBuilder.append(String.valueOf(calculateEncodedLengthHelper(multipartMessage)));
                        stringBuilder.append(' ');
                        encodeAsMessageHelper(stringBuilder, multipartMessage);
                        i++;
                    }
                    return;
                default:
                    stringBuilder.append(pluginResult.getMessage());
                    return;
            }
        }

        void encodeAsMessage(StringBuilder stringBuilder) {
            Object obj = 1;
            if (this.pluginResult == null) {
                stringBuilder.append('J').append(this.jsPayloadOrCallbackId);
                return;
            }
            int status = this.pluginResult.getStatus();
            Object obj2 = status == Status.NO_RESULT.ordinal() ? 1 : null;
            if (status != Status.OK.ordinal()) {
                obj = null;
            }
            boolean keepCallback = this.pluginResult.getKeepCallback();
            char c = (obj2 == null && obj == null) ? 'F' : 'S';
            stringBuilder.append(c).append(keepCallback ? '1' : '0').append(status).append(' ').append(this.jsPayloadOrCallbackId).append(' ');
            encodeAsMessageHelper(stringBuilder, this.pluginResult);
        }

        void buildJsMessage(StringBuilder stringBuilder) {
            switch (this.pluginResult.getMessageType()) {
                case 6:
                    stringBuilder.append("cordova.require('cordova/base64').toArrayBuffer('").append(this.pluginResult.getMessage()).append("')");
                    return;
                case 7:
                    stringBuilder.append("atob('").append(this.pluginResult.getMessage()).append("')");
                    return;
                case 8:
                    int multipartMessagesSize = this.pluginResult.getMultipartMessagesSize();
                    for (int i = 0; i < multipartMessagesSize; i++) {
                        new JsMessage(this.pluginResult.getMultipartMessage(i), this.jsPayloadOrCallbackId).buildJsMessage(stringBuilder);
                        if (i < multipartMessagesSize - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    return;
                default:
                    stringBuilder.append(this.pluginResult.getMessage());
                    return;
            }
        }

        void encodeAsJsMessage(StringBuilder stringBuilder) {
            if (this.pluginResult == null) {
                stringBuilder.append(this.jsPayloadOrCallbackId);
                return;
            }
            int status = this.pluginResult.getStatus();
            boolean z = status == Status.OK.ordinal() || status == Status.NO_RESULT.ordinal();
            stringBuilder.append("cordova.callbackFromNative('").append(this.jsPayloadOrCallbackId).append("',").append(z).append(",").append(status).append(",[");
            buildJsMessage(stringBuilder);
            stringBuilder.append("],").append(this.pluginResult.getKeepCallback()).append(");");
        }
    }

    public static class LoadUrlBridgeMode extends BridgeMode {
        private final CordovaInterface cordova;
        private final CordovaWebViewEngine engine;

        public LoadUrlBridgeMode(CordovaWebViewEngine cordovaWebViewEngine, CordovaInterface cordovaInterface) {
            this.engine = cordovaWebViewEngine;
            this.cordova = cordovaInterface;
        }

        public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue nativeToJsMessageQueue) {
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    String popAndEncodeAsJs = nativeToJsMessageQueue.popAndEncodeAsJs();
                    if (popAndEncodeAsJs != null) {
                        LoadUrlBridgeMode.this.engine.loadUrl("javascript:" + popAndEncodeAsJs, false);
                    }
                }
            });
        }
    }

    public static class NoOpBridgeMode extends BridgeMode {
        public void onNativeToJsMessageAvailable(NativeToJsMessageQueue nativeToJsMessageQueue) {
        }
    }

    public static class OnlineEventsBridgeMode extends BridgeMode {
        private final OnlineEventsBridgeModeDelegate delegate;
        private boolean ignoreNextFlush;
        private boolean online;

        /* renamed from: org.apache.cordova.NativeToJsMessageQueue$OnlineEventsBridgeMode$1 */
        class C05261 implements Runnable {
            C05261() {
            }

            public void run() {
                OnlineEventsBridgeMode.this.online = false;
                OnlineEventsBridgeMode.this.ignoreNextFlush = true;
                OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(true);
            }
        }

        public interface OnlineEventsBridgeModeDelegate {
            void runOnUiThread(Runnable runnable);

            void setNetworkAvailable(boolean z);
        }

        public OnlineEventsBridgeMode(OnlineEventsBridgeModeDelegate onlineEventsBridgeModeDelegate) {
            this.delegate = onlineEventsBridgeModeDelegate;
        }

        public void reset() {
            this.delegate.runOnUiThread(new C05261());
        }

        public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue nativeToJsMessageQueue) {
            this.delegate.runOnUiThread(new Runnable() {
                public void run() {
                    if (!nativeToJsMessageQueue.isEmpty()) {
                        OnlineEventsBridgeMode.this.ignoreNextFlush = false;
                        OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(OnlineEventsBridgeMode.this.online);
                    }
                }
            });
        }

        public void notifyOfFlush(NativeToJsMessageQueue nativeToJsMessageQueue, boolean z) {
            if (z && !this.ignoreNextFlush) {
                this.online = !this.online;
            }
        }
    }

    public void addBridgeMode(BridgeMode bridgeMode) {
        this.bridgeModes.add(bridgeMode);
    }

    public boolean isBridgeEnabled() {
        return this.activeBridgeMode != null;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void setBridgeMode(int i) {
        if (i < -1 || i >= this.bridgeModes.size()) {
            LOG.m1345d(LOG_TAG, "Invalid NativeToJsBridgeMode: " + i);
            return;
        }
        BridgeMode bridgeMode = i < 0 ? null : (BridgeMode) this.bridgeModes.get(i);
        if (bridgeMode != this.activeBridgeMode) {
            LOG.m1345d(LOG_TAG, "Set native->JS mode to " + (bridgeMode == null ? "null" : bridgeMode.getClass().getSimpleName()));
            synchronized (this) {
                this.activeBridgeMode = bridgeMode;
                if (bridgeMode != null) {
                    bridgeMode.reset();
                    if (!(this.paused || this.queue.isEmpty())) {
                        bridgeMode.onNativeToJsMessageAvailable(this);
                    }
                }
            }
        }
    }

    public void reset() {
        synchronized (this) {
            this.queue.clear();
            setBridgeMode(-1);
        }
    }

    private int calculatePackedMessageLength(JsMessage jsMessage) {
        int calculateEncodedLength = jsMessage.calculateEncodedLength();
        return (calculateEncodedLength + String.valueOf(calculateEncodedLength).length()) + 1;
    }

    private void packMessage(JsMessage jsMessage, StringBuilder stringBuilder) {
        stringBuilder.append(jsMessage.calculateEncodedLength()).append(' ');
        jsMessage.encodeAsMessage(stringBuilder);
    }

    public String popAndEncode(boolean z) {
        String str = null;
        int i = 0;
        synchronized (this) {
            if (this.activeBridgeMode == null) {
            } else {
                this.activeBridgeMode.notifyOfFlush(this, z);
                if (this.queue.isEmpty()) {
                } else {
                    Iterator it = this.queue.iterator();
                    int i2 = 0;
                    int i3 = 0;
                    while (it.hasNext()) {
                        int calculatePackedMessageLength = calculatePackedMessageLength((JsMessage) it.next());
                        if (i2 > 0 && i3 + calculatePackedMessageLength > MAX_PAYLOAD_SIZE && MAX_PAYLOAD_SIZE > 0) {
                            break;
                        }
                        i3 += calculatePackedMessageLength;
                        i2++;
                    }
                    StringBuilder stringBuilder = new StringBuilder(i3);
                    while (i < i2) {
                        packMessage((JsMessage) this.queue.removeFirst(), stringBuilder);
                        i++;
                    }
                    if (!this.queue.isEmpty()) {
                        stringBuilder.append('*');
                    }
                    str = stringBuilder.toString();
                }
            }
        }
        return str;
    }

    public String popAndEncodeAsJs() {
        String str;
        synchronized (this) {
            if (this.queue.size() == 0) {
                str = null;
            } else {
                int calculateEncodedLength;
                Object obj;
                Iterator it = this.queue.iterator();
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    calculateEncodedLength = ((JsMessage) it.next()).calculateEncodedLength() + 50;
                    if (i > 0 && i2 + calculateEncodedLength > MAX_PAYLOAD_SIZE && MAX_PAYLOAD_SIZE > 0) {
                        break;
                    }
                    i2 += calculateEncodedLength;
                    i++;
                }
                if (i == this.queue.size()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                StringBuilder stringBuilder = new StringBuilder((obj != null ? 0 : 100) + i2);
                i2 = 0;
                while (i2 < i) {
                    JsMessage jsMessage = (JsMessage) this.queue.removeFirst();
                    if (obj == null || i2 + 1 != i) {
                        stringBuilder.append("try{");
                        jsMessage.encodeAsJsMessage(stringBuilder);
                        stringBuilder.append("}finally{");
                    } else {
                        jsMessage.encodeAsJsMessage(stringBuilder);
                    }
                    i2++;
                }
                if (obj == null) {
                    stringBuilder.append("window.setTimeout(function(){cordova.require('cordova/plugin/android/polling').pollOnce();},0);");
                }
                calculateEncodedLength = obj != null ? 1 : 0;
                while (calculateEncodedLength < i) {
                    stringBuilder.append('}');
                    calculateEncodedLength++;
                }
                str = stringBuilder.toString();
            }
        }
        return str;
    }

    public void addJavaScript(String str) {
        enqueueMessage(new JsMessage(str));
    }

    public void addPluginResult(PluginResult pluginResult, String str) {
        if (str == null) {
            LOG.m1349e(LOG_TAG, "Got plugin result with no callbackId", new Throwable());
            return;
        }
        Object obj = pluginResult.getStatus() == Status.NO_RESULT.ordinal() ? 1 : null;
        boolean keepCallback = pluginResult.getKeepCallback();
        if (obj == null || !keepCallback) {
            enqueueMessage(new JsMessage(pluginResult, str));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void enqueueMessage(org.apache.cordova.NativeToJsMessageQueue.JsMessage r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.activeBridgeMode;	 Catch:{ all -> 0x001e }
        if (r0 != 0) goto L_0x000e;
    L_0x0005:
        r0 = "JsMessageQueue";
        r1 = "Dropping Native->JS message due to disabled bridge";
        org.apache.cordova.LOG.m1345d(r0, r1);	 Catch:{ all -> 0x001e }
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
    L_0x000d:
        return;
    L_0x000e:
        r0 = r2.queue;	 Catch:{ all -> 0x001e }
        r0.add(r3);	 Catch:{ all -> 0x001e }
        r0 = r2.paused;	 Catch:{ all -> 0x001e }
        if (r0 != 0) goto L_0x001c;
    L_0x0017:
        r0 = r2.activeBridgeMode;	 Catch:{ all -> 0x001e }
        r0.onNativeToJsMessageAvailable(r2);	 Catch:{ all -> 0x001e }
    L_0x001c:
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000d;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.NativeToJsMessageQueue.enqueueMessage(org.apache.cordova.NativeToJsMessageQueue$JsMessage):void");
    }

    public void setPaused(boolean z) {
        if (this.paused && z) {
            LOG.m1349e(LOG_TAG, "nested call to setPaused detected.", new Throwable());
        }
        this.paused = z;
        if (!z) {
            synchronized (this) {
                if (!(this.queue.isEmpty() || this.activeBridgeMode == null)) {
                    this.activeBridgeMode.onNativeToJsMessageAvailable(this);
                }
            }
        }
    }
}
