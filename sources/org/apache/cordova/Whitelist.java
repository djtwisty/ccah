package org.apache.cordova;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;

public class Whitelist {
    public static final String TAG = "Whitelist";
    private ArrayList<URLPattern> whiteList = new ArrayList();

    private static class URLPattern {
        public Pattern host;
        public Pattern path;
        public Integer port;
        public Pattern scheme;

        private String regexFromPattern(String str, boolean z) {
            String str2 = "\\.[]{}()^$?+|";
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt == '*' && z) {
                    stringBuilder.append(".");
                } else if ("\\.[]{}()^$?+|".indexOf(charAt) > -1) {
                    stringBuilder.append('\\');
                }
                stringBuilder.append(charAt);
            }
            return stringBuilder.toString();
        }

        public URLPattern(String str, String str2, String str3, String str4) {
            if (str != null) {
                try {
                    if (!"*".equals(str)) {
                        this.scheme = Pattern.compile(regexFromPattern(str, false), 2);
                        if ("*".equals(str2)) {
                            this.host = null;
                        } else if (str2.startsWith("*.")) {
                            this.host = Pattern.compile(regexFromPattern(str2, false), 2);
                        } else {
                            this.host = Pattern.compile("([a-z0-9.-]*\\.)?" + regexFromPattern(str2.substring(2), false), 2);
                        }
                        if (str3 != null || "*".equals(str3)) {
                            this.port = null;
                        } else {
                            this.port = Integer.valueOf(Integer.parseInt(str3, 10));
                        }
                        if (str4 != null || "/*".equals(str4)) {
                            this.path = null;
                        } else {
                            this.path = Pattern.compile(regexFromPattern(str4, true));
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    throw new MalformedURLException("Port must be a number");
                }
            }
            this.scheme = null;
            if ("*".equals(str2)) {
                this.host = null;
            } else if (str2.startsWith("*.")) {
                this.host = Pattern.compile(regexFromPattern(str2, false), 2);
            } else {
                this.host = Pattern.compile("([a-z0-9.-]*\\.)?" + regexFromPattern(str2.substring(2), false), 2);
            }
            if (str3 != null) {
            }
            this.port = null;
            if (str4 != null) {
            }
            this.path = null;
        }

        public boolean matches(Uri uri) {
            try {
                if (this.scheme != null && !this.scheme.matcher(uri.getScheme()).matches()) {
                    return false;
                }
                if (this.host != null && !this.host.matcher(uri.getHost()).matches()) {
                    return false;
                }
                if (this.port != null && !this.port.equals(Integer.valueOf(uri.getPort()))) {
                    return false;
                }
                if (this.path == null || this.path.matcher(uri.getPath()).matches()) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                LOG.m1345d(Whitelist.TAG, e.toString());
                return false;
            }
        }
    }

    public void addWhiteListEntry(String str, boolean z) {
        if (this.whiteList != null) {
            try {
                if (str.compareTo("*") == 0) {
                    LOG.m1345d(TAG, "Unlimited access to network resources");
                    this.whiteList = null;
                    return;
                }
                Matcher matcher = Pattern.compile("^((\\*|[A-Za-z-]+):(//)?)?(\\*|((\\*\\.)?[^*/:]+))?(:(\\d+))?(/.*)?").matcher(str);
                if (matcher.matches()) {
                    String group = matcher.group(2);
                    String group2 = matcher.group(4);
                    if (("file".equals(group) || Param.CONTENT.equals(group)) && group2 == null) {
                        group2 = "*";
                    }
                    String group3 = matcher.group(8);
                    String group4 = matcher.group(9);
                    if (group == null) {
                        this.whiteList.add(new URLPattern(HttpHost.DEFAULT_SCHEME_NAME, group2, group3, group4));
                        this.whiteList.add(new URLPattern("https", group2, group3, group4));
                        return;
                    }
                    this.whiteList.add(new URLPattern(group, group2, group3, group4));
                }
            } catch (Exception e) {
                LOG.m1347d(TAG, "Failed to add origin %s", str);
            }
        }
    }

    public boolean isUrlWhiteListed(String str) {
        if (this.whiteList == null) {
            return true;
        }
        Uri parse = Uri.parse(str);
        Iterator it = this.whiteList.iterator();
        while (it.hasNext()) {
            if (((URLPattern) it.next()).matches(parse)) {
                return true;
            }
        }
        return false;
    }
}
