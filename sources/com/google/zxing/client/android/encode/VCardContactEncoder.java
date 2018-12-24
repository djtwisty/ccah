package com.google.zxing.client.android.encode;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.zxing.client.android.Intents.WifiConnect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class VCardContactEncoder extends ContactEncoder {
    private static final char TERMINATOR = '\n';

    VCardContactEncoder() {
    }

    public String[] encode(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2) {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("BEGIN:VCARD").append(TERMINATOR);
        stringBuilder.append("VERSION:3.0").append(TERMINATOR);
        StringBuilder stringBuilder2 = new StringBuilder(100);
        Formatter vCardFieldFormatter = new VCardFieldFormatter();
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "N", list, 1, null, vCardFieldFormatter, TERMINATOR);
        ContactEncoder.append(stringBuilder, stringBuilder2, "ORG", str, vCardFieldFormatter, TERMINATOR);
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "ADR", list2, 1, null, vCardFieldFormatter, TERMINATOR);
        List buildPhoneMetadata = buildPhoneMetadata(list3, list4);
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "TEL", list3, BaseClientBuilder.API_PRIORITY_OTHER, new VCardTelDisplayFormatter(buildPhoneMetadata), new VCardFieldFormatter(buildPhoneMetadata), TERMINATOR);
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "EMAIL", list5, BaseClientBuilder.API_PRIORITY_OTHER, null, vCardFieldFormatter, TERMINATOR);
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "URL", list6, BaseClientBuilder.API_PRIORITY_OTHER, null, vCardFieldFormatter, TERMINATOR);
        ContactEncoder.append(stringBuilder, stringBuilder2, "NOTE", str2, vCardFieldFormatter, TERMINATOR);
        stringBuilder.append("END:VCARD").append(TERMINATOR);
        return new String[]{stringBuilder.toString(), stringBuilder2.toString()};
    }

    private static List<Map<String, Set<String>>> buildPhoneMetadata(Collection<String> collection, List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<Map<String, Set<String>>> arrayList = new ArrayList();
        for (int i = 0; i < collection.size(); i++) {
            if (list.size() <= i) {
                arrayList.add(null);
            } else {
                Map hashMap = new HashMap();
                arrayList.add(hashMap);
                Set hashSet = new HashSet();
                hashMap.put(WifiConnect.TYPE, hashSet);
                String str = (String) list.get(i);
                Integer maybeIntValue = maybeIntValue(str);
                if (maybeIntValue == null) {
                    hashSet.add(str);
                } else {
                    str = vCardPurposeLabelForAndroidType(maybeIntValue.intValue());
                    String vCardContextLabelForAndroidType = vCardContextLabelForAndroidType(maybeIntValue.intValue());
                    if (str != null) {
                        hashSet.add(str);
                    }
                    if (vCardContextLabelForAndroidType != null) {
                        hashSet.add(vCardContextLabelForAndroidType);
                    }
                }
            }
        }
        return arrayList;
    }

    private static Integer maybeIntValue(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static String vCardPurposeLabelForAndroidType(int i) {
        switch (i) {
            case 4:
            case 5:
            case 13:
                return "fax";
            case 6:
            case 18:
                return "pager";
            case 16:
                return "textphone";
            case 20:
                return "text";
            default:
                return null;
        }
    }

    private static String vCardContextLabelForAndroidType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 5:
            case 6:
                return "home";
            case 3:
            case 4:
            case 10:
            case 17:
            case 18:
                return "work";
            default:
                return null;
        }
    }
}
