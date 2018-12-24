package org.apache.cordova;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.protocol.HTTP;

public class CordovaResourceApi {
    private static final String[] LOCAL_FILE_PROJECTION = new String[]{"_data"};
    private static final String LOG_TAG = "CordovaResourceApi";
    public static final String PLUGIN_URI_SCHEME = "cdvplugin";
    public static final int URI_TYPE_ASSET = 1;
    public static final int URI_TYPE_CONTENT = 2;
    public static final int URI_TYPE_DATA = 4;
    public static final int URI_TYPE_FILE = 0;
    public static final int URI_TYPE_HTTP = 5;
    public static final int URI_TYPE_HTTPS = 6;
    public static final int URI_TYPE_PLUGIN = 7;
    public static final int URI_TYPE_RESOURCE = 3;
    public static final int URI_TYPE_UNKNOWN = -1;
    public static Thread jsThread;
    private final AssetManager assetManager;
    private final ContentResolver contentResolver;
    private final PluginManager pluginManager;
    private boolean threadCheckingEnabled = true;

    public static final class OpenForReadResult {
        public final AssetFileDescriptor assetFd;
        public final InputStream inputStream;
        public final long length;
        public final String mimeType;
        public final Uri uri;

        public OpenForReadResult(Uri uri, InputStream inputStream, String str, long j, AssetFileDescriptor assetFileDescriptor) {
            this.uri = uri;
            this.inputStream = inputStream;
            this.mimeType = str;
            this.length = j;
            this.assetFd = assetFileDescriptor;
        }
    }

    public void copyResource(org.apache.cordova.CordovaResourceApi.OpenForReadResult r10, java.io.OutputStream r11) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003d in list [B:12:0x003a]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/587003819.run(Unknown Source)
*/
        /*
        r9 = this;
        r4 = 0;
        r9.assertBackgroundThread();
        r2 = r10.inputStream;	 Catch:{ all -> 0x0050 }
        r3 = r2 instanceof java.io.FileInputStream;	 Catch:{ all -> 0x0050 }
        if (r3 == 0) goto L_0x003e;	 Catch:{ all -> 0x0050 }
    L_0x000b:
        r3 = r11 instanceof java.io.FileOutputStream;	 Catch:{ all -> 0x0050 }
        if (r3 == 0) goto L_0x003e;	 Catch:{ all -> 0x0050 }
    L_0x000f:
        r2 = r10.inputStream;	 Catch:{ all -> 0x0050 }
        r2 = (java.io.FileInputStream) r2;	 Catch:{ all -> 0x0050 }
        r3 = r2.getChannel();	 Catch:{ all -> 0x0050 }
        r0 = r11;	 Catch:{ all -> 0x0050 }
        r0 = (java.io.FileOutputStream) r0;	 Catch:{ all -> 0x0050 }
        r2 = r0;	 Catch:{ all -> 0x0050 }
        r2 = r2.getChannel();	 Catch:{ all -> 0x0050 }
        r6 = r10.length;	 Catch:{ all -> 0x0050 }
        r8 = r10.assetFd;	 Catch:{ all -> 0x0050 }
        if (r8 == 0) goto L_0x002b;	 Catch:{ all -> 0x0050 }
    L_0x0025:
        r4 = r10.assetFd;	 Catch:{ all -> 0x0050 }
        r4 = r4.getStartOffset();	 Catch:{ all -> 0x0050 }
    L_0x002b:
        r3.position(r4);	 Catch:{ all -> 0x0050 }
        r4 = 0;	 Catch:{ all -> 0x0050 }
        r2.transferFrom(r3, r4, r6);	 Catch:{ all -> 0x0050 }
    L_0x0033:
        r2 = r10.inputStream;
        r2.close();
        if (r11 == 0) goto L_0x003d;
    L_0x003a:
        r11.close();
    L_0x003d:
        return;
    L_0x003e:
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r3 = new byte[r3];	 Catch:{ all -> 0x0050 }
    L_0x0042:
        r4 = 0;	 Catch:{ all -> 0x0050 }
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ all -> 0x0050 }
        r4 = r2.read(r3, r4, r5);	 Catch:{ all -> 0x0050 }
        if (r4 <= 0) goto L_0x0033;	 Catch:{ all -> 0x0050 }
    L_0x004b:
        r5 = 0;	 Catch:{ all -> 0x0050 }
        r11.write(r3, r5, r4);	 Catch:{ all -> 0x0050 }
        goto L_0x0042;
    L_0x0050:
        r2 = move-exception;
        r3 = r10.inputStream;
        r3.close();
        if (r11 == 0) goto L_0x005b;
    L_0x0058:
        r11.close();
    L_0x005b:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.CordovaResourceApi.copyResource(org.apache.cordova.CordovaResourceApi$OpenForReadResult, java.io.OutputStream):void");
    }

    public CordovaResourceApi(Context context, PluginManager pluginManager) {
        this.contentResolver = context.getContentResolver();
        this.assetManager = context.getAssets();
        this.pluginManager = pluginManager;
    }

    public void setThreadCheckingEnabled(boolean z) {
        this.threadCheckingEnabled = z;
    }

    public boolean isThreadCheckingEnabled() {
        return this.threadCheckingEnabled;
    }

    public static int getUriType(Uri uri) {
        assertNonRelative(uri);
        String scheme = uri.getScheme();
        if (Param.CONTENT.equalsIgnoreCase(scheme)) {
            return 2;
        }
        if ("android.resource".equalsIgnoreCase(scheme)) {
            return 3;
        }
        if ("file".equalsIgnoreCase(scheme)) {
            if (uri.getPath().startsWith("/android_asset/")) {
                return 1;
            }
            return 0;
        } else if ("data".equalsIgnoreCase(scheme)) {
            return 4;
        } else {
            if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme)) {
                return 5;
            }
            if ("https".equalsIgnoreCase(scheme)) {
                return 6;
            }
            if (PLUGIN_URI_SCHEME.equalsIgnoreCase(scheme)) {
                return 7;
            }
            return -1;
        }
    }

    public Uri remapUri(Uri uri) {
        assertNonRelative(uri);
        Uri remapUri = this.pluginManager.remapUri(uri);
        return remapUri != null ? remapUri : uri;
    }

    public String remapPath(String str) {
        return remapUri(Uri.fromFile(new File(str))).getPath();
    }

    public File mapUriToFile(Uri uri) {
        File file = null;
        assertBackgroundThread();
        switch (getUriType(uri)) {
            case 0:
                return new File(uri.getPath());
            case 2:
                Cursor query = this.contentResolver.query(uri, LOCAL_FILE_PROJECTION, null, null, null);
                if (query == null) {
                    return null;
                }
                try {
                    int columnIndex = query.getColumnIndex(LOCAL_FILE_PROJECTION[0]);
                    if (columnIndex != -1 && query.getCount() > 0) {
                        query.moveToFirst();
                        String string = query.getString(columnIndex);
                        if (string != null) {
                            file = new File(string);
                            return file;
                        }
                    }
                    query.close();
                    return null;
                } finally {
                    query.close();
                }
            default:
                return null;
        }
    }

    public String getMimeType(Uri uri) {
        switch (getUriType(uri)) {
            case 0:
            case 1:
                return getMimeTypeFromPath(uri.getPath());
            case 2:
            case 3:
                return this.contentResolver.getType(uri);
            case 4:
                return getDataUriMimeType(uri);
            case 5:
            case 6:
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
                    httpURLConnection.setDoInput(false);
                    httpURLConnection.setRequestMethod(HttpHead.METHOD_NAME);
                    String headerField = httpURLConnection.getHeaderField(HTTP.CONTENT_TYPE);
                    if (headerField != null) {
                        return headerField.split(";")[0];
                    }
                    return headerField;
                } catch (IOException e) {
                    break;
                }
        }
        return null;
    }

    private String getMimeTypeFromPath(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str = str.substring(lastIndexOf + 1);
        }
        String toLowerCase = str.toLowerCase(Locale.getDefault());
        if (toLowerCase.equals("3ga")) {
            return "audio/3gpp";
        }
        if (toLowerCase.equals("js")) {
            return "text/javascript";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(toLowerCase);
    }

    public OpenForReadResult openForRead(Uri uri) {
        return openForRead(uri, false);
    }

    public OpenForReadResult openForRead(Uri uri, boolean z) {
        AssetFileDescriptor assetFileDescriptor = null;
        if (!z) {
            assertBackgroundThread();
        }
        InputStream fileInputStream;
        String type;
        switch (getUriType(uri)) {
            case 0:
                fileInputStream = new FileInputStream(uri.getPath());
                return new OpenForReadResult(uri, fileInputStream, getMimeTypeFromPath(uri.getPath()), fileInputStream.getChannel().size(), null);
            case 1:
                String substring = uri.getPath().substring(15);
                long j = -1;
                try {
                    assetFileDescriptor = this.assetManager.openFd(substring);
                    fileInputStream = assetFileDescriptor.createInputStream();
                    j = assetFileDescriptor.getLength();
                } catch (FileNotFoundException e) {
                    fileInputStream = this.assetManager.open(substring);
                }
                return new OpenForReadResult(uri, fileInputStream, getMimeTypeFromPath(substring), j, assetFileDescriptor);
            case 2:
            case 3:
                type = this.contentResolver.getType(uri);
                assetFileDescriptor = this.contentResolver.openAssetFileDescriptor(uri, "r");
                return new OpenForReadResult(uri, assetFileDescriptor.createInputStream(), type, assetFileDescriptor.getLength(), assetFileDescriptor);
            case 4:
                OpenForReadResult readDataUri = readDataUri(uri);
                if (readDataUri == null) {
                    break;
                }
                return readDataUri;
            case 5:
            case 6:
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
                httpURLConnection.setDoInput(true);
                type = httpURLConnection.getHeaderField(HTTP.CONTENT_TYPE);
                if (type != null) {
                    type = type.split(";")[0];
                }
                return new OpenForReadResult(uri, httpURLConnection.getInputStream(), type, (long) httpURLConnection.getContentLength(), null);
            case 7:
                CordovaPlugin plugin = this.pluginManager.getPlugin(uri.getHost());
                if (plugin != null) {
                    return plugin.handleOpenForRead(uri);
                }
                throw new FileNotFoundException("Invalid plugin ID in URI: " + uri);
        }
        throw new FileNotFoundException("URI not supported by CordovaResourceApi: " + uri);
    }

    public OutputStream openOutputStream(Uri uri) {
        return openOutputStream(uri, false);
    }

    public OutputStream openOutputStream(Uri uri, boolean z) {
        assertBackgroundThread();
        switch (getUriType(uri)) {
            case 0:
                File file = new File(uri.getPath());
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                return new FileOutputStream(file, z);
            case 2:
            case 3:
                return this.contentResolver.openAssetFileDescriptor(uri, z ? "wa" : "w").createOutputStream();
            default:
                throw new FileNotFoundException("URI not supported by CordovaResourceApi: " + uri);
        }
    }

    public HttpURLConnection createHttpConnection(Uri uri) {
        assertBackgroundThread();
        return (HttpURLConnection) new URL(uri.toString()).openConnection();
    }

    public void copyResource(Uri uri, OutputStream outputStream) {
        copyResource(openForRead(uri), outputStream);
    }

    public void copyResource(Uri uri, Uri uri2) {
        copyResource(openForRead(uri), openOutputStream(uri2));
    }

    private void assertBackgroundThread() {
        if (this.threadCheckingEnabled) {
            Thread currentThread = Thread.currentThread();
            if (currentThread == Looper.getMainLooper().getThread()) {
                throw new IllegalStateException("Do not perform IO operations on the UI thread. Use CordovaInterface.getThreadPool() instead.");
            } else if (currentThread == jsThread) {
                throw new IllegalStateException("Tried to perform an IO operation on the WebCore thread. Use CordovaInterface.getThreadPool() instead.");
            }
        }
    }

    private String getDataUriMimeType(Uri uri) {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int indexOf = schemeSpecificPart.indexOf(44);
        if (indexOf == -1) {
            return null;
        }
        String[] split = schemeSpecificPart.substring(0, indexOf).split(";");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    private OpenForReadResult readDataUri(Uri uri) {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int indexOf = schemeSpecificPart.indexOf(44);
        if (indexOf == -1) {
            return null;
        }
        String str;
        byte[] decode;
        String[] split = schemeSpecificPart.substring(0, indexOf).split(";");
        if (split.length > 0) {
            str = split[0];
        } else {
            str = null;
        }
        int i = 0;
        for (int i2 = 1; i2 < split.length; i2++) {
            if ("base64".equalsIgnoreCase(split[i2])) {
                i = 1;
            }
        }
        String substring = schemeSpecificPart.substring(indexOf + 1);
        if (i != 0) {
            decode = Base64.decode(substring, 0);
        } else {
            try {
                decode = substring.getBytes(HTTP.UTF_8);
            } catch (UnsupportedEncodingException e) {
                decode = substring.getBytes();
            }
        }
        return new OpenForReadResult(uri, new ByteArrayInputStream(decode), str, (long) decode.length, null);
    }

    private static void assertNonRelative(Uri uri) {
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("Relative URIs are not supported.");
        }
    }
}
