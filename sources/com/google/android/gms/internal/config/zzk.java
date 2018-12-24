package com.google.android.gms.internal.config;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
public interface zzk extends Result {
    Status getStatus();

    long getThrottleEndTimeMillis();

    byte[] zza(String str, byte[] bArr, String str2);

    List<byte[]> zzh();

    Map<String, Set<String>> zzi();
}
