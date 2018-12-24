package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;

public final class EmailAddressResultParser extends ResultParser {
    private static final Pattern COMMA = Pattern.compile(",");

    public EmailAddressParsedResult parse(Result result) {
        EmailAddressParsedResult emailAddressParsedResult = null;
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("mailto:") || massagedText.startsWith("MAILTO:")) {
            String substring = massagedText.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            try {
                String[] strArr;
                String[] split;
                String str;
                String str2;
                String[] strArr2;
                CharSequence urlDecode = ResultParser.urlDecode(substring);
                if (urlDecode.isEmpty()) {
                    strArr = null;
                } else {
                    strArr = COMMA.split(urlDecode);
                }
                Map parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
                if (parseNameValuePairs != null) {
                    String[] split2;
                    if (strArr == null) {
                        substring = (String) parseNameValuePairs.get("to");
                        if (substring != null) {
                            split2 = COMMA.split(substring);
                            substring = (String) parseNameValuePairs.get("cc");
                            if (substring == null) {
                                split = COMMA.split(substring);
                            } else {
                                split = null;
                            }
                            substring = (String) parseNameValuePairs.get("bcc");
                            if (substring != null) {
                                emailAddressParsedResult = COMMA.split(substring);
                            }
                            str = (String) parseNameValuePairs.get("body");
                            str2 = (String) parseNameValuePairs.get("subject");
                            strArr2 = emailAddressParsedResult;
                            strArr = split2;
                        }
                    }
                    split2 = strArr;
                    substring = (String) parseNameValuePairs.get("cc");
                    if (substring == null) {
                        split = null;
                    } else {
                        split = COMMA.split(substring);
                    }
                    substring = (String) parseNameValuePairs.get("bcc");
                    if (substring != null) {
                        emailAddressParsedResult = COMMA.split(substring);
                    }
                    str = (String) parseNameValuePairs.get("body");
                    str2 = (String) parseNameValuePairs.get("subject");
                    strArr2 = emailAddressParsedResult;
                    strArr = split2;
                } else {
                    str = null;
                    str2 = null;
                    strArr2 = null;
                    split = null;
                }
                return new EmailAddressParsedResult(strArr, split, strArr2, str2, str);
            } catch (IllegalArgumentException e) {
                return null;
            }
        } else if (EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
            return new EmailAddressParsedResult(massagedText);
        } else {
            return null;
        }
    }
}
