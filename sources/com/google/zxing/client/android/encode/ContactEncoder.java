package com.google.zxing.client.android.encode;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

abstract class ContactEncoder {
    abstract String[] encode(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2);

    ContactEncoder() {
    }

    static String trim(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim;
    }

    static void append(StringBuilder stringBuilder, StringBuilder stringBuilder2, String str, String str2, Formatter formatter, char c) {
        Object trim = trim(str2);
        if (trim != null) {
            stringBuilder.append(str).append(formatter.format(trim, 0)).append(c);
            stringBuilder2.append(trim).append('\n');
        }
    }

    static void appendUpToUnique(StringBuilder stringBuilder, StringBuilder stringBuilder2, String str, List<String> list, int i, Formatter formatter, Formatter formatter2, char c) {
        if (list != null) {
            Collection hashSet = new HashSet(2);
            int i2 = 0;
            int i3 = 0;
            while (i2 < list.size()) {
                CharSequence trim = trim((String) list.get(i2));
                if (!(trim == null || trim.isEmpty() || hashSet.contains(trim))) {
                    stringBuilder.append(str).append(formatter2.format(trim, i2)).append(c);
                    stringBuilder2.append(formatter == null ? trim : formatter.format(trim, i2)).append('\n');
                    i3++;
                    if (i3 != i) {
                        hashSet.add(trim);
                    } else {
                        return;
                    }
                }
                i2++;
            }
        }
    }
}
