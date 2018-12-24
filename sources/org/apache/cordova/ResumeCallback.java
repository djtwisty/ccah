package org.apache.cordova;

public class ResumeCallback extends CallbackContext {
    private final String TAG = "CordovaResumeCallback";
    private PluginManager pluginManager;
    private String serviceName;

    public ResumeCallback(String str, PluginManager pluginManager) {
        super("resumecallback", null);
        this.serviceName = str;
        this.pluginManager = pluginManager;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendPluginResult(org.apache.cordova.PluginResult r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.finished;	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x0029;
    L_0x0005:
        r0 = "CordovaResumeCallback";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007e }
        r1.<init>();	 Catch:{ all -> 0x007e }
        r2 = r5.serviceName;	 Catch:{ all -> 0x007e }
        r1 = r1.append(r2);	 Catch:{ all -> 0x007e }
        r2 = " attempted to send a second callback to ResumeCallback\nResult was: ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x007e }
        r2 = r6.getMessage();	 Catch:{ all -> 0x007e }
        r1 = r1.append(r2);	 Catch:{ all -> 0x007e }
        r1 = r1.toString();	 Catch:{ all -> 0x007e }
        org.apache.cordova.LOG.m1357w(r0, r1);	 Catch:{ all -> 0x007e }
        monitor-exit(r5);	 Catch:{ all -> 0x007e }
    L_0x0028:
        return;
    L_0x0029:
        r0 = 1;
        r5.finished = r0;	 Catch:{ all -> 0x007e }
        monitor-exit(r5);	 Catch:{ all -> 0x007e }
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = new org.json.JSONObject;
        r1.<init>();
        r2 = "pluginServiceName";
        r3 = r5.serviceName;	 Catch:{ JSONException -> 0x0081 }
        r1.put(r2, r3);	 Catch:{ JSONException -> 0x0081 }
        r2 = "pluginStatus";
        r3 = org.apache.cordova.PluginResult.StatusMessages;	 Catch:{ JSONException -> 0x0081 }
        r4 = r6.getStatus();	 Catch:{ JSONException -> 0x0081 }
        r3 = r3[r4];	 Catch:{ JSONException -> 0x0081 }
        r1.put(r2, r3);	 Catch:{ JSONException -> 0x0081 }
        r2 = "action";
        r3 = "resume";
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0081 }
        r2 = "pendingResult";
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x0081 }
    L_0x0057:
        r1 = new org.apache.cordova.PluginResult;
        r2 = org.apache.cordova.PluginResult.Status.OK;
        r1.<init>(r2, r0);
        r2 = new java.util.ArrayList;
        r2.<init>();
        r2.add(r1);
        r2.add(r6);
        r0 = r5.pluginManager;
        r1 = "CoreAndroid";
        r0 = r0.getPlugin(r1);
        r0 = (org.apache.cordova.CoreAndroid) r0;
        r1 = new org.apache.cordova.PluginResult;
        r3 = org.apache.cordova.PluginResult.Status.OK;
        r1.<init>(r3, r2);
        r0.sendResumeEvent(r1);
        goto L_0x0028;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x007e }
        throw r0;
    L_0x0081:
        r1 = move-exception;
        r1 = "CordovaResumeCallback";
        r2 = "Unable to create resume object for Activity Result";
        org.apache.cordova.LOG.m1348e(r1, r2);
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.ResumeCallback.sendPluginResult(org.apache.cordova.PluginResult):void");
    }
}
