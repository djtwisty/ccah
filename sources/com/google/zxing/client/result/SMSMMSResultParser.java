package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class SMSMMSResultParser extends ResultParser {
    public SMSParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("sms:") && !massagedText.startsWith("SMS:") && !massagedText.startsWith("mms:") && !massagedText.startsWith("MMS:")) {
            return null;
        }
        int i;
        String str;
        String str2;
        Map parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
        if (parseNameValuePairs == null || parseNameValuePairs.isEmpty()) {
            i = 0;
            str = null;
            str2 = null;
        } else {
            String str3 = (String) parseNameValuePairs.get("subject");
            i = 1;
            str = (String) parseNameValuePairs.get("body");
            str2 = str3;
        }
        int indexOf = massagedText.indexOf(63, 4);
        if (indexOf < 0 || r2 == 0) {
            str3 = massagedText.substring(4);
        } else {
            str3 = massagedText.substring(4, indexOf);
        }
        int i2 = -1;
        List arrayList = new ArrayList(1);
        List arrayList2 = new ArrayList(1);
        while (true) {
            i = str3.indexOf(44, i2 + 1);
            if (i > i2) {
                addNumberVia(arrayList, arrayList2, str3.substring(i2 + 1, i));
                i2 = i;
            } else {
                addNumberVia(arrayList, arrayList2, str3.substring(i2 + 1));
                return new SMSParsedResult((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
        }
    }

    private static void addNumberVia(Collection<String> collection, Collection<String> collection2, String str) {
        Object obj = null;
        int indexOf = str.indexOf(59);
        if (indexOf < 0) {
            collection.add(str);
            collection2.add(null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith("via=")) {
            obj = substring.substring(4);
        }
        collection2.add(obj);
    }
}
