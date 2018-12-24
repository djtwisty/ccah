package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.cordova.networkinformation.NetworkManager;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.protocol.HTTP;

@VisibleForTesting
public final class zzhu {
    private final String zzazo;
    private int zzbfk;
    private final zzcm zzbih;
    private final zzcd zzbir;
    private final zzqb zzbke;
    private final zzia zzbkf = new zzia();
    private final zzqz zzbkg = new zzqz(new HashMap(50));
    private final zzqz zzbkh = new zzqz(new HashMap(10));
    private final Set<String> zzbki = new HashSet();
    private zzno zzbkj;
    private zzgt zzbkk;
    private final zzhy zzbkl = new zzhv(this);
    private final Context zzri;

    @VisibleForTesting
    public zzhu(Context context, String str, zzqb zzqb, zzqj zzqj, zzcm zzcm, zzcd zzcd) {
        Preconditions.checkNotNull(zzqb, "Internal Error: Container resource cannot be null");
        Preconditions.checkNotNull(zzqj, "Internal Error: Runtime resource cannot be null");
        Preconditions.checkNotEmpty(str, "Internal Error: ContainerId cannot be empty");
        Preconditions.checkNotNull(zzcm);
        Preconditions.checkNotNull(zzcd);
        this.zzri = context;
        this.zzazo = str;
        this.zzbke = zzqb;
        this.zzbih = zzcm;
        this.zzbir = zzcd;
        this.zzbkf.zza("1", new zzqu(new zzkn()));
        this.zzbkf.zza("12", new zzqu(new zzko()));
        this.zzbkf.zza("18", new zzqu(new zzkp()));
        this.zzbkf.zza("19", new zzqu(new zzkq()));
        this.zzbkf.zza("20", new zzqu(new zzkr()));
        this.zzbkf.zza("21", new zzqu(new zzks()));
        this.zzbkf.zza("23", new zzqu(new zzkt()));
        this.zzbkf.zza("24", new zzqu(new zzku()));
        this.zzbkf.zza("27", new zzqu(new zzkv()));
        this.zzbkf.zza("28", new zzqu(new zzkw()));
        this.zzbkf.zza("29", new zzqu(new zzkx()));
        this.zzbkf.zza("30", new zzqu(new zzky()));
        this.zzbkf.zza("32", new zzqu(new zzkz()));
        this.zzbkf.zza("33", new zzqu(new zzkz()));
        this.zzbkf.zza("34", new zzqu(new zzla()));
        this.zzbkf.zza("35", new zzqu(new zzla()));
        this.zzbkf.zza("39", new zzqu(new zzlb()));
        this.zzbkf.zza("40", new zzqu(new zzlc()));
        this.zzbkf.zza("0", new zzqu(new zzlz()));
        this.zzbkf.zza("10", new zzqu(new zzma()));
        this.zzbkf.zza("25", new zzqu(new zzmb()));
        this.zzbkf.zza("26", new zzqu(new zzmc()));
        this.zzbkf.zza("37", new zzqu(new zzmd()));
        this.zzbkf.zza("2", new zzqu(new zzld()));
        this.zzbkf.zza("3", new zzqu(new zzle()));
        this.zzbkf.zza("4", new zzqu(new zzlf()));
        this.zzbkf.zza("5", new zzqu(new zzlg()));
        this.zzbkf.zza("6", new zzqu(new zzlh()));
        this.zzbkf.zza("7", new zzqu(new zzli()));
        this.zzbkf.zza("8", new zzqu(new zzlj()));
        this.zzbkf.zza("9", new zzqu(new zzlg()));
        this.zzbkf.zza("13", new zzqu(new zzlk()));
        this.zzbkf.zza("47", new zzqu(new zzll()));
        this.zzbkf.zza("15", new zzqu(new zzlm()));
        this.zzbkf.zza("48", new zzqu(new zzln(this)));
        zzjo zzlo = new zzlo();
        this.zzbkf.zza("16", new zzqu(zzlo));
        this.zzbkf.zza("17", new zzqu(zzlo));
        this.zzbkf.zza("22", new zzqu(new zzlq()));
        this.zzbkf.zza("45", new zzqu(new zzlr()));
        this.zzbkf.zza("46", new zzqu(new zzls()));
        this.zzbkf.zza("36", new zzqu(new zzlt()));
        this.zzbkf.zza("43", new zzqu(new zzlu()));
        this.zzbkf.zza("38", new zzqu(new zzlv()));
        this.zzbkf.zza("44", new zzqu(new zzlw()));
        this.zzbkf.zza("41", new zzqu(new zzlx()));
        this.zzbkf.zza("42", new zzqu(new zzly()));
        zza(zza.CONTAINS, new zzol());
        zza(zza.ENDS_WITH, new zzom());
        zza(zza.EQUALS, new zzon());
        zza(zza.GREATER_EQUALS, new zzoo());
        zza(zza.GREATER_THAN, new zzop());
        zza(zza.LESS_EQUALS, new zzoq());
        zza(zza.LESS_THAN, new zzor());
        zza(zza.REGEX, new zzot());
        zza(zza.STARTS_WITH, new zzou());
        this.zzbkg.zzc("advertiserId", new zzqu(new zzne(this.zzri)));
        this.zzbkg.zzc("advertiserTrackingEnabled", new zzqu(new zznf(this.zzri)));
        this.zzbkg.zzc("adwordsClickReferrer", new zzqu(new zzng(this.zzri, this.zzbkl)));
        this.zzbkg.zzc("applicationId", new zzqu(new zznh(this.zzri)));
        this.zzbkg.zzc("applicationName", new zzqu(new zzni(this.zzri)));
        this.zzbkg.zzc("applicationVersion", new zzqu(new zznj(this.zzri)));
        this.zzbkg.zzc("applicationVersionName", new zzqu(new zznk(this.zzri)));
        this.zzbkg.zzc("arbitraryPixieMacro", new zzqu(new zznb(1, this.zzbkf)));
        this.zzbkg.zzc("carrier", new zzqu(new zznl(this.zzri)));
        this.zzbkg.zzc("constant", new zzqu(new zzlt()));
        this.zzbkg.zzc("containerId", new zzqu(new zznm(new zzrb(this.zzazo))));
        this.zzbkg.zzc("containerVersion", new zzqu(new zznm(new zzrb(this.zzbke.getVersion()))));
        this.zzbkg.zzc("customMacro", new zzqu(new zzmz(new zzhx())));
        this.zzbkg.zzc("deviceBrand", new zzqu(new zznp()));
        this.zzbkg.zzc("deviceId", new zzqu(new zznq(this.zzri)));
        this.zzbkg.zzc("deviceModel", new zzqu(new zznr()));
        this.zzbkg.zzc("deviceName", new zzqu(new zzns()));
        this.zzbkg.zzc("encode", new zzqu(new zznt()));
        this.zzbkg.zzc("encrypt", new zzqu(new zznu()));
        this.zzbkg.zzc("event", new zzqu(new zznn()));
        this.zzbkg.zzc("eventParameters", new zzqu(new zznv(this.zzbkl)));
        this.zzbkg.zzc(ClientCookie.VERSION_ATTR, new zzqu(new zznw()));
        this.zzbkg.zzc("hashcode", new zzqu(new zznx()));
        this.zzbkg.zzc("installReferrer", new zzqu(new zzny(this.zzri)));
        this.zzbkg.zzc("join", new zzqu(new zznz()));
        this.zzbkg.zzc("language", new zzqu(new zzoa()));
        this.zzbkg.zzc("locale", new zzqu(new zzob()));
        this.zzbkg.zzc("adWordsUniqueId", new zzqu(new zzod(this.zzri)));
        this.zzbkg.zzc("osVersion", new zzqu(new zzoe()));
        this.zzbkg.zzc("platform", new zzqu(new zzof()));
        this.zzbkg.zzc("random", new zzqu(new zzog()));
        this.zzbkg.zzc("regexGroup", new zzqu(new zzoh()));
        this.zzbkg.zzc("resolution", new zzqu(new zzoj(this.zzri)));
        this.zzbkg.zzc("runtimeVersion", new zzqu(new zzoi()));
        this.zzbkg.zzc("sdkVersion", new zzqu(new zzok()));
        this.zzbkj = new zzno();
        this.zzbkg.zzc("currentTime", new zzqu(this.zzbkj));
        this.zzbkg.zzc("userProperty", new zzqu(new zzoc(this.zzri, this.zzbkl)));
        this.zzbkg.zzc("arbitraryPixel", new zzqu(new zzox(zzgr.zzy(this.zzri))));
        this.zzbkg.zzc("customTag", new zzqu(new zzmz(new zzhw())));
        this.zzbkg.zzc("universalAnalytics", new zzqu(new zzoy(this.zzri, this.zzbkl)));
        this.zzbkg.zzc("queueRequest", new zzqu(new zzov(zzgr.zzy(this.zzri))));
        this.zzbkg.zzc("sendMeasurement", new zzqu(new zzow(this.zzbih, this.zzbkl)));
        this.zzbkg.zzc("arbitraryPixieTag", new zzqu(new zznb(0, this.zzbkf)));
        this.zzbkg.zzc("suppressPassthrough", new zzqu(new zznd(this.zzri, this.zzbkl)));
        this.zzbkh.zzc("decodeURI", new zzqu(new zzmu()));
        this.zzbkh.zzc("decodeURIComponent", new zzqu(new zzmv()));
        this.zzbkh.zzc("encodeURI", new zzqu(new zzmw()));
        this.zzbkh.zzc("encodeURIComponent", new zzqu(new zzmx()));
        this.zzbkh.zzc("log", new zzqu(new zznc()));
        this.zzbkh.zzc("isArray", new zzqu(new zzmy()));
        for (zzjn zzjn : zzqj.zzsp()) {
            zzjn.zza(this.zzbkf);
            this.zzbkf.zza(zzjn.getName(), new zzqu(zzjn));
        }
        zzqp zzqz = new zzqz(new HashMap(1));
        zzqz.zzc(NetworkManager.MOBILE, this.zzbkg);
        zzqz.zzc("common", this.zzbkh);
        this.zzbkf.zza("gtmUtils", zzqz);
        zzqp zzqz2 = new zzqz(new HashMap((Map) this.zzbkg.value()));
        zzqz2.zzsw();
        zzqp zzqz3 = new zzqz(new HashMap((Map) this.zzbkh.value()));
        zzqz3.zzsw();
        if (this.zzbkf.has("main") && (this.zzbkf.zzeq("main") instanceof zzqu)) {
            List arrayList = new ArrayList();
            arrayList.add(zzqz);
            zzrd.zza(this.zzbkf, new zzra("main", arrayList));
        }
        this.zzbkg.zzc("base", zzqz2);
        this.zzbkh.zzc("base", zzqz3);
        zzqz.zzsw();
        this.zzbkg.zzsw();
        this.zzbkh.zzsw();
    }

    public final zzqp<?> zzen(String str) {
        if (this.zzbki.contains(str)) {
            String obj = this.zzbki.toString();
            throw new IllegalStateException(new StringBuilder((String.valueOf(str).length() + 77) + String.valueOf(obj).length()).append("Macro cycle detected.  Current macro reference: ").append(str).append(". Previous macro references: ").append(obj).toString());
        }
        this.zzbfk = 0;
        return zzeo(str);
    }

    public final void zzb(zzgt zzgt) {
        boolean z;
        Throwable e;
        this.zzbkf.zza("gtm.globals.eventName", new zzrb(zzgt.zzqt()));
        this.zzbkj.zza(zzgt);
        this.zzbkk = zzgt;
        Set<zzqd> hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        Map hashMap = new HashMap();
        for (zzqg zzqg : this.zzbke.zzsg()) {
            String valueOf;
            if (zzqg.zzsm().isEmpty() && zzqg.zzsn().isEmpty()) {
                String valueOf2 = String.valueOf(zzqg);
                zzhk.m1082v(new StringBuilder(String.valueOf(valueOf2).length() + 64).append("Trigger is not being evaluated since it has no associated tags: ").append(valueOf2).toString());
            } else {
                zzqp zzqp;
                zzqp zzqp2;
                valueOf = String.valueOf(zzqg);
                zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Evaluating trigger ").append(valueOf).toString());
                for (zzqd zzqd : zzqg.zzsl()) {
                    zzqp = (zzqp) hashMap.get(zzqd);
                    if (zzqp == null) {
                        zzqp = zza(zzqd);
                        hashMap.put(zzqd, zzqp);
                    }
                    zzqp2 = zzqp;
                    if (zzqp2 != zzqv.zzbpq) {
                        if (((Boolean) ((zzqs) zzqp2).value()).booleanValue()) {
                            zzqp2 = new zzqs(Boolean.valueOf(false));
                            break;
                        }
                    }
                    zzqp2 = zzqv.zzbpq;
                    break;
                }
                for (zzqd zzqd2 : zzqg.zzsk()) {
                    zzqp = (zzqp) hashMap.get(zzqd2);
                    if (zzqp == null) {
                        zzqp = zza(zzqd2);
                        hashMap.put(zzqd2, zzqp);
                    }
                    zzqp2 = zzqp;
                    if (zzqp2 != zzqv.zzbpq) {
                        if (!((Boolean) ((zzqs) zzqp2).value()).booleanValue()) {
                            zzqp2 = new zzqs(Boolean.valueOf(false));
                            break;
                        }
                    }
                    zzqp2 = zzqv.zzbpq;
                    break;
                }
                zzqp2 = new zzqs(Boolean.valueOf(true));
                if (zzqp2 == zzqv.zzbpq) {
                    valueOf = String.valueOf(zzqg);
                    zzgp.zzb(new StringBuilder(String.valueOf(valueOf).length() + 41).append("Error encounted while evaluating trigger ").append(valueOf).toString(), this.zzri);
                    if (!zzqg.zzsn().isEmpty()) {
                        valueOf = String.valueOf(zzqg.zzsn());
                        zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Blocking tags: ").append(valueOf).toString());
                        hashSet2.addAll(zzqg.zzsn());
                    }
                } else if (((Boolean) ((zzqs) zzqp2).value()).booleanValue()) {
                    valueOf = String.valueOf(zzqg);
                    zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Trigger is firing: ").append(valueOf).toString());
                    if (!zzqg.zzsm().isEmpty()) {
                        valueOf = String.valueOf(zzqg.zzsm());
                        zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 34).append("Adding tags to firing candidates: ").append(valueOf).toString());
                        hashSet.addAll(zzqg.zzsm());
                    }
                    if (!zzqg.zzsn().isEmpty()) {
                        valueOf = String.valueOf(zzqg.zzsn());
                        zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Blocking disabled tags: ").append(valueOf).toString());
                        hashSet2.addAll(zzqg.zzsn());
                    }
                }
            }
        }
        hashSet.removeAll(hashSet2);
        boolean z2 = false;
        for (zzqd zzqd3 : hashSet) {
            this.zzbki.clear();
            valueOf = String.valueOf(zzqd3);
            zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 21).append("Executing firing tag ").append(valueOf).toString());
            try {
                boolean z3;
                zzj(zzi(zzqd3.zzsi()));
                zzqm zzqm = (zzqm) zzqd3.zzsi().get(zzb.DISPATCH_ON_FIRE.toString());
                if (zzqm != null && zzqm.getType() == 8 && ((Boolean) zzqm.getValue()).booleanValue()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    try {
                        valueOf = String.valueOf(zzqd3);
                        zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Tag configured to dispatch on fire: ").append(valueOf).toString());
                        z3 = true;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        z = true;
                        valueOf2 = String.valueOf(zzqd3);
                        zzgp.zza(new StringBuilder(String.valueOf(valueOf2).length() + 19).append("Error firing tag ").append(valueOf2).append(": ").toString(), e, this.zzri);
                        z2 = z;
                    }
                } else {
                    z3 = z2;
                }
                z2 = z3;
            } catch (IllegalStateException e3) {
                e = e3;
                z = z2;
                valueOf2 = String.valueOf(zzqd3);
                zzgp.zza(new StringBuilder(String.valueOf(valueOf2).length() + 19).append("Error firing tag ").append(valueOf2).append(": ").toString(), e, this.zzri);
                z2 = z;
            }
        }
        this.zzbkf.remove("gtm.globals.eventName");
        if (zzgt.zzqw()) {
            valueOf2 = zzgt.zzqt();
            zzhk.m1082v(new StringBuilder(String.valueOf(valueOf2).length() + 35).append("Log passthrough event ").append(valueOf2).append(" to Firebase.").toString());
            try {
                this.zzbih.logEventInternalNoInterceptor(zzgt.zzqv(), zzgt.zzqt(), zzgt.zzqu(), zzgt.currentTimeMillis());
            } catch (Throwable e4) {
                zzgp.zza("Error calling measurement proxy: ", e4, this.zzri);
            }
        } else {
            valueOf2 = zzgt.zzqt();
            zzhk.m1082v(new StringBuilder(String.valueOf(valueOf2).length() + 63).append("Non-passthrough event ").append(valueOf2).append(" doesn't get logged to Firebase directly.").toString());
        }
        if (z2) {
            zzhk.m1082v("Dispatch called for dispatchOnFire tags.");
            dispatch();
        }
    }

    private final void zza(zza zza, zzjo zzjo) {
        this.zzbkg.zzc(zzjl.zza(zza), new zzqu(zzjo));
    }

    public final void dispatch() {
        zzgr.zzy(this.zzri).dispatch();
    }

    private final Map<String, zzqp<?>> zzi(Map<String, zzqm> map) {
        Map<String, zzqp<?>> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), zza((zzqm) entry.getValue()));
        }
        return hashMap;
    }

    private final zzqp<?> zza(zzqm zzqm) {
        switch (zzqm.getType()) {
            case 1:
                try {
                    return new zzqt(Double.valueOf(Double.parseDouble((String) zzqm.getValue())));
                } catch (NumberFormatException e) {
                    return new zzrb((String) zzqm.getValue());
                }
            case 2:
                List<zzqm> list = (List) zzqm.getValue();
                List arrayList = new ArrayList(list.size());
                for (zzqm zza : list) {
                    arrayList.add(zza(zza));
                }
                return new zzqw(arrayList);
            case 3:
                Map map = (Map) zzqm.getValue();
                Map hashMap = new HashMap(map.size());
                for (Entry entry : map.entrySet()) {
                    zzqp zza2 = zza((zzqm) entry.getKey());
                    hashMap.put(zzjp.zzd(zza2), zza((zzqm) entry.getValue()));
                }
                return new zzqz(hashMap);
            case 4:
                zzqp<?> zzeo = zzeo((String) zzqm.getValue());
                if (!(zzeo instanceof zzrb) || zzqm.zzsr().isEmpty()) {
                    return zzeo;
                }
                String str = (String) ((zzrb) zzeo).value();
                String str2 = str;
                for (Integer intValue : zzqm.zzsr()) {
                    int intValue2 = intValue.intValue();
                    switch (intValue2) {
                        case 12:
                            str = zzep(str2);
                            break;
                        default:
                            zzhk.m1081e("Unsupported Value Escaping: " + intValue2);
                            str = str2;
                            break;
                    }
                    str2 = str;
                }
                return new zzrb(str2);
            case 5:
                return new zzrb((String) zzqm.getValue());
            case 6:
                return new zzqt(Double.valueOf(((Integer) zzqm.getValue()).doubleValue()));
            case 7:
                StringBuilder stringBuilder = new StringBuilder();
                for (zzqm zza3 : (List) zzqm.getValue()) {
                    stringBuilder.append(zzjp.zzd(zza(zza3)));
                }
                return new zzrb(stringBuilder.toString());
            case 8:
                return new zzqs((Boolean) zzqm.getValue());
            default:
                throw new IllegalStateException("Attempting to expand unknown Value type " + zzqm.getType() + ".");
        }
    }

    private final zzqp<?> zzeo(String str) {
        this.zzbfk++;
        String zzpu = zzpu();
        zzhk.m1082v(new StringBuilder((String.valueOf(zzpu).length() + 31) + String.valueOf(str).length()).append(zzpu).append("Beginning to evaluate variable ").append(str).toString());
        if (this.zzbki.contains(str)) {
            this.zzbfk--;
            String obj = this.zzbki.toString();
            throw new IllegalStateException(new StringBuilder((String.valueOf(str).length() + 77) + String.valueOf(obj).length()).append("Macro cycle detected.  Current macro reference: ").append(str).append(". Previous macro references: ").append(obj).toString());
        }
        this.zzbki.add(str);
        zzqd zzfa = this.zzbke.zzfa(str);
        if (zzfa == null) {
            this.zzbfk--;
            this.zzbki.remove(str);
            obj = zzpu();
            throw new IllegalStateException(new StringBuilder((String.valueOf(obj).length() + 36) + String.valueOf(str).length()).append(obj).append("Attempting to resolve unknown macro ").append(str).toString());
        }
        zzqp<?> zzj = zzj(zzi(zzfa.zzsi()));
        obj = zzpu();
        zzhk.m1082v(new StringBuilder((String.valueOf(obj).length() + 25) + String.valueOf(str).length()).append(obj).append("Done evaluating variable ").append(str).toString());
        this.zzbfk--;
        this.zzbki.remove(str);
        return zzj;
    }

    @VisibleForTesting
    private final zzqp<?> zza(zzqd zzqd) {
        this.zzbki.clear();
        try {
            zzqp<?> zzj = zzj(zzi(zzqd.zzsi()));
            if (zzj instanceof zzqs) {
                return zzj;
            }
            zzgp.zza("Predicate must return a boolean value", this.zzri);
            return new zzqs(Boolean.valueOf(false));
        } catch (IllegalStateException e) {
            zzhk.m1081e("Error evaluating predicate.");
            return zzqv.zzbpq;
        }
    }

    private final zzqp zzj(Map<String, zzqp<?>> map) {
        if (map == null) {
            zzgp.zza("executeFunctionCall: cannot access the function parameters.", this.zzri);
            return zzqv.zzbpr;
        }
        zzqp zzqp = (zzqp) map.get(zzb.FUNCTION.toString());
        if (zzqp instanceof zzrb) {
            zzra zzra;
            String str = (String) ((zzrb) zzqp).value();
            if (this.zzbkf.has(str)) {
                Map hashMap = new HashMap();
                for (Entry entry : map.entrySet()) {
                    if (((String) entry.getKey()).startsWith("vtp_")) {
                        hashMap.put(((String) entry.getKey()).substring(4), (zzqp) entry.getValue());
                    }
                }
                List arrayList = new ArrayList();
                arrayList.add(new zzqz(hashMap));
                zzra = new zzra(str, arrayList);
            } else {
                String zzes = zzjl.zzes(str);
                Object obj = (zzes == null || !this.zzbkg.zzfd(zzes)) ? null : 1;
                if (obj != null) {
                    zzra = zzd(str, map);
                } else {
                    zzgp.zza(new StringBuilder(String.valueOf(str).length() + 30).append("functionId '").append(str).append("' is not supported").toString(), this.zzri);
                    return zzqv.zzbpr;
                }
            }
            if (zzra == null) {
                zzgp.zza("Internal error: failed to convert function to a valid statement", this.zzri);
                return zzqv.zzbpr;
            }
            String str2 = "Executing: ";
            str = String.valueOf(zzra.zzsx());
            zzhk.m1082v(str.length() != 0 ? str2.concat(str) : new String(str2));
            zzqp zza = zzrd.zza(this.zzbkf, zzra);
            if ((zza instanceof zzqv) && ((zzqv) zza).zzsv()) {
                return (zzqp) ((zzqv) zza).value();
            }
            return zza;
        }
        zzgp.zza("No function id in properties", this.zzri);
        return zzqv.zzbpr;
    }

    private final zzra zzd(String str, Map<String, zzqp<?>> map) {
        try {
            return zzjl.zza(str, map, this.zzbkf);
        } catch (RuntimeException e) {
            String message = e.getMessage();
            zzhk.m1081e(new StringBuilder((String.valueOf(str).length() + 30) + String.valueOf(message).length()).append("Incorrect keys for function ").append(str).append(". ").append(message).toString());
            return null;
        }
    }

    private static String zzep(String str) {
        try {
            str = URLEncoder.encode(str, HTTP.UTF_8).replaceAll("\\+", "%20");
        } catch (Throwable e) {
            zzhk.zza("Escape URI: unsupported encoding", e);
        }
        return str;
    }

    private final String zzpu() {
        if (this.zzbfk <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.zzbfk));
        for (int i = 2; i < this.zzbfk; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }
}
