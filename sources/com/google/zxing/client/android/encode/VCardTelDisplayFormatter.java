package com.google.zxing.client.android.encode;

import android.telephony.PhoneNumberUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class VCardTelDisplayFormatter implements Formatter {
    private final List<Map<String, Set<String>>> metadataForIndex;

    VCardTelDisplayFormatter() {
        this(null);
    }

    VCardTelDisplayFormatter(List<Map<String, Set<String>>> list) {
        this.metadataForIndex = list;
    }

    public CharSequence format(CharSequence charSequence, int i) {
        CharSequence formatNumber = PhoneNumberUtils.formatNumber(charSequence.toString());
        Map map = (this.metadataForIndex == null || this.metadataForIndex.size() <= i) ? null : (Map) this.metadataForIndex.get(i);
        return formatMetadata(formatNumber, map);
    }

    private static CharSequence formatMetadata(CharSequence charSequence, Map<String, Set<String>> map) {
        if (map == null || map.isEmpty()) {
            return charSequence;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry value : map.entrySet()) {
            Set set = (Set) value.getValue();
            if (!(set == null || set.isEmpty())) {
                Iterator it = set.iterator();
                stringBuilder.append((String) it.next());
                while (it.hasNext()) {
                    stringBuilder.append(',').append((String) it.next());
                }
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(charSequence);
        return stringBuilder;
    }
}
