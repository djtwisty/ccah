package org.apache.cordova;

public interface ExposedJsApi {
    String exec(int i, String str, String str2, String str3, String str4);

    String retrieveJsMessages(int i, boolean z);

    void setNativeToJsBridgeMode(int i, int i2);
}
