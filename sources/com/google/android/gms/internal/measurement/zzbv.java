package com.google.android.gms.internal.measurement;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

class zzbv<T extends zzbu> extends zzat {
    private zzbw<T> zzyj;

    public zzbv(zzaw zzaw, zzbw<T> zzbw) {
        super(zzaw);
        this.zzyj = zzbw;
    }

    public final T zzq(int i) {
        try {
            return zza(zzbw().zzcm().getResources().getXml(i));
        } catch (NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }

    private final T zza(XmlResourceParser xmlResourceParser) {
        Object attributeValue;
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    String trim;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.zzyj.zzb(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim == null)) {
                            this.zzyj.zzc(attributeValue, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(r1))) {
                            try {
                                this.zzyj.zza(attributeValue, Boolean.parseBoolean(r1));
                            } catch (NumberFormatException e) {
                                zzc("Error parsing bool configuration value", r1, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(r1))) {
                            try {
                                this.zzyj.zzb(toLowerCase, Integer.parseInt(r1));
                            } catch (NumberFormatException e2) {
                                zzc("Error parsing int configuration value", r1, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            attributeValue = e3;
        } catch (IOException e4) {
            attributeValue = e4;
        }
        return this.zzyj.zzdv();
        zze("Error parsing tracker configuration file", attributeValue);
        return this.zzyj.zzdv();
    }
}
