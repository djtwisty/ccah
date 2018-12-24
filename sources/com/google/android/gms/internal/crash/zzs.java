package com.google.android.gms.internal.crash;

import android.content.Context;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.FlagRegistry;
import com.google.android.gms.flags.Singletons;
import java.util.concurrent.TimeUnit;

public final class zzs {
    public static final Flag<Boolean> zzap = Flag.define(0, "crash:enabled", Boolean.valueOf(true));
    private static final Flag<String> zzaq = Flag.define(0, "crash:gateway_url", "https://mobilecrashreporting.googleapis.com/v1/crashes:batchCreate?key=");
    private static final Flag<Integer> zzar = Flag.define(0, "crash:log_buffer_capacity", 100);
    private static final Flag<Integer> zzas = Flag.define(0, "crash:log_buffer_max_total_size", 32768);
    private static final Flag<Integer> zzat = Flag.define(0, "crash:crash_backlog_capacity", 5);
    private static final Flag<Long> zzau = Flag.define(0, "crash:crash_backlog_max_age", 604800000);
    private static final Flag<Long> zzav = Flag.define(0, "crash:starting_backoff", TimeUnit.SECONDS.toMillis(1));
    private static final Flag<Long> zzaw = Flag.define(0, "crash:backoff_limit", TimeUnit.MINUTES.toMillis(60));
    private static final Flag<Integer> zzax = Flag.define(0, "crash:retry_num_attempts", 12);
    private static final Flag<Integer> zzay = Flag.define(0, "crash:batch_size", 5);
    private static final Flag<Long> zzaz = Flag.define(0, "crash:batch_throttle", TimeUnit.MINUTES.toMillis(5));
    private static final Flag<Integer> zzba = Flag.define(0, "crash:frame_depth", 60);
    private static final Flag<Integer> zzbb = Flag.define(0, "crash:receiver_delay", 100);
    private static final Flag<Integer> zzbc = Flag.define(0, "crash:thread_idle_timeout", 10);

    public static final void initialize(Context context) {
        Singletons.flagRegistry();
        FlagRegistry.initialize(context);
    }
}
