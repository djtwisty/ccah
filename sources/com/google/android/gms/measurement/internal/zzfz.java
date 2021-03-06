package com.google.android.gms.measurement.internal;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class zzfz extends SSLSocketFactory {
    private final SSLSocketFactory zzaus;

    zzfz() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private zzfz(SSLSocketFactory sSLSocketFactory) {
        this.zzaus = sSLSocketFactory;
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return zza((SSLSocket) this.zzaus.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.zzaus.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzaus.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i) {
        return zza((SSLSocket) this.zzaus.createSocket(str, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return zza((SSLSocket) this.zzaus.createSocket(inetAddress, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return zza((SSLSocket) this.zzaus.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return zza((SSLSocket) this.zzaus.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket() {
        return zza((SSLSocket) this.zzaus.createSocket());
    }

    private final SSLSocket zza(SSLSocket sSLSocket) {
        return new zzga(this, sSLSocket);
    }
}
