package com.google.zxing.client.android.encode;

import android.telephony.PhoneNumberUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.List;
import java.util.regex.Pattern;

final class MECARDContactEncoder extends ContactEncoder {
    private static final char TERMINATOR = ';';

    private static class MECARDFieldFormatter implements Formatter {
        private static final Pattern NEWLINE = Pattern.compile("\\n");
        private static final Pattern RESERVED_MECARD_CHARS = Pattern.compile("([\\\\:;])");

        private MECARDFieldFormatter() {
        }

        public CharSequence format(CharSequence charSequence, int i) {
            return ':' + NEWLINE.matcher(RESERVED_MECARD_CHARS.matcher(charSequence).replaceAll("\\\\$1")).replaceAll("");
        }
    }

    private static class MECARDNameDisplayFormatter implements Formatter {
        private static final Pattern COMMA = Pattern.compile(",");

        private MECARDNameDisplayFormatter() {
        }

        public CharSequence format(CharSequence charSequence, int i) {
            return COMMA.matcher(charSequence).replaceAll("");
        }
    }

    private static class MECARDTelDisplayFormatter implements Formatter {
        private static final Pattern NOT_DIGITS = Pattern.compile("[^0-9]+");

        private MECARDTelDisplayFormatter() {
        }

        public CharSequence format(CharSequence charSequence, int i) {
            return NOT_DIGITS.matcher(PhoneNumberUtils.formatNumber(charSequence.toString())).replaceAll("");
        }
    }

    MECARDContactEncoder() {
    }

    public String[] encode(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2) {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("MECARD:");
        StringBuilder stringBuilder2 = new StringBuilder(100);
        Formatter mECARDFieldFormatter = new MECARDFieldFormatter();
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "N", list, 1, new MECARDNameDisplayFormatter(), mECARDFieldFormatter, TERMINATOR);
        ContactEncoder.append(stringBuilder, stringBuilder2, "ORG", str, mECARDFieldFormatter, TERMINATOR);
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "ADR", list2, 1, null, mECARDFieldFormatter, TERMINATOR);
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "TEL", list3, BaseClientBuilder.API_PRIORITY_OTHER, new MECARDTelDisplayFormatter(), mECARDFieldFormatter, TERMINATOR);
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "EMAIL", list5, BaseClientBuilder.API_PRIORITY_OTHER, null, mECARDFieldFormatter, TERMINATOR);
        ContactEncoder.appendUpToUnique(stringBuilder, stringBuilder2, "URL", list6, BaseClientBuilder.API_PRIORITY_OTHER, null, mECARDFieldFormatter, TERMINATOR);
        ContactEncoder.append(stringBuilder, stringBuilder2, "NOTE", str2, mECARDFieldFormatter, TERMINATOR);
        stringBuilder.append(TERMINATOR);
        return new String[]{stringBuilder.toString(), stringBuilder2.toString()};
    }
}
