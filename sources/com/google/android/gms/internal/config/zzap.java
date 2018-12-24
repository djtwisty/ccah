package com.google.android.gms.internal.config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public final class zzap implements FirebaseRemoteConfigValue {
    public static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    public static final Pattern zzm = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    public static final Pattern zzn = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    private final byte[] zzba;
    private final int zzbb;

    public zzap(byte[] bArr, int i) {
        this.zzba = bArr;
        this.zzbb = i;
    }

    public final long asLong() {
        if (this.zzbb == 0) {
            return 0;
        }
        try {
            return Long.valueOf(asString().trim()).longValue();
        } catch (Throwable e) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{r1, "long"}), e);
        }
    }

    public final double asDouble() {
        if (this.zzbb == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        try {
            return Double.valueOf(asString().trim()).doubleValue();
        } catch (Throwable e) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{r1, "double"}), e);
        }
    }

    public final String asString() {
        if (this.zzbb == 0) {
            return "";
        }
        if (this.zzba != null) {
            return new String(this.zzba, UTF_8);
        }
        throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
    }

    public final byte[] asByteArray() {
        if (this.zzbb == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        return this.zzba;
    }

    public final boolean asBoolean() {
        if (this.zzbb == 0) {
            return false;
        }
        CharSequence trim = asString().trim();
        if (zzm.matcher(trim).matches()) {
            return true;
        }
        if (zzn.matcher(trim).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{trim, "boolean"}));
    }

    public final int getSource() {
        return this.zzbb;
    }
}
