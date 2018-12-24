package com.google.zxing.client.android.encode;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

final class VCardFieldFormatter implements Formatter {
    private static final Pattern NEWLINE = Pattern.compile("\\n");
    private static final Pattern RESERVED_VCARD_CHARS = Pattern.compile("([\\\\,;])");
    private final List<Map<String, Set<String>>> metadataForIndex;

    VCardFieldFormatter() {
        this(null);
    }

    VCardFieldFormatter(List<Map<String, Set<String>>> list) {
        this.metadataForIndex = list;
    }

    public CharSequence format(CharSequence charSequence, int i) {
        CharSequence replaceAll = NEWLINE.matcher(RESERVED_VCARD_CHARS.matcher(charSequence).replaceAll("\\\\$1")).replaceAll("");
        Map map = (this.metadataForIndex == null || this.metadataForIndex.size() <= i) ? null : (Map) this.metadataForIndex.get(i);
        return formatMetadata(replaceAll, map);
    }

    private static CharSequence formatMetadata(CharSequence charSequence, Map<String, Set<String>> map) {
        CharSequence stringBuilder = new StringBuilder();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                Set set = (Set) entry.getValue();
                if (!(set == null || set.isEmpty())) {
                    stringBuilder.append(';').append((String) entry.getKey()).append('=');
                    if (set.size() > 1) {
                        stringBuilder.append('\"');
                    }
                    Iterator it = set.iterator();
                    stringBuilder.append((String) it.next());
                    while (it.hasNext()) {
                        stringBuilder.append(',').append((String) it.next());
                    }
                    if (set.size() > 1) {
                        stringBuilder.append('\"');
                    }
                }
            }
        }
        stringBuilder.append(':').append(charSequence);
        return stringBuilder;
    }
}
