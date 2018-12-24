package org.apache.cordova.whitelist;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.Whitelist;
import org.xmlpull.v1.XmlPullParser;

public class WhitelistPlugin extends CordovaPlugin {
    private static final String LOG_TAG = "WhitelistPlugin";
    private Whitelist allowedIntents;
    private Whitelist allowedNavigations;
    private Whitelist allowedRequests;

    private class CustomConfigXmlParser extends ConfigXmlParser {
        private CustomConfigXmlParser() {
        }

        public void handleStartTag(XmlPullParser xmlPullParser) {
            boolean z = true;
            String name = xmlPullParser.getName();
            if (name.equals(Param.CONTENT)) {
                WhitelistPlugin.this.allowedNavigations.addWhiteListEntry(xmlPullParser.getAttributeValue(null, "src"), false);
            } else if (name.equals("allow-navigation")) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "href");
                if ("*".equals(attributeValue)) {
                    WhitelistPlugin.this.allowedNavigations.addWhiteListEntry("http://*/*", false);
                    WhitelistPlugin.this.allowedNavigations.addWhiteListEntry("https://*/*", false);
                    WhitelistPlugin.this.allowedNavigations.addWhiteListEntry("data:*", false);
                    return;
                }
                WhitelistPlugin.this.allowedNavigations.addWhiteListEntry(attributeValue, false);
            } else if (name.equals("allow-intent")) {
                WhitelistPlugin.this.allowedIntents.addWhiteListEntry(xmlPullParser.getAttributeValue(null, "href"), false);
            } else if (name.equals("access")) {
                boolean z2;
                String attributeValue2 = xmlPullParser.getAttributeValue(null, Param.ORIGIN);
                String attributeValue3 = xmlPullParser.getAttributeValue(null, "subdomains");
                if (xmlPullParser.getAttributeValue(null, "launch-external") != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (attributeValue2 == null) {
                    return;
                }
                Whitelist access$200;
                if (z2) {
                    LOG.m1357w(WhitelistPlugin.LOG_TAG, "Found <access launch-external> within config.xml. Please use <allow-intent> instead.");
                    access$200 = WhitelistPlugin.this.allowedIntents;
                    if (attributeValue3 == null || attributeValue3.compareToIgnoreCase("true") != 0) {
                        z = false;
                    }
                    access$200.addWhiteListEntry(attributeValue2, z);
                } else if ("*".equals(attributeValue2)) {
                    WhitelistPlugin.this.allowedRequests.addWhiteListEntry("http://*/*", false);
                    WhitelistPlugin.this.allowedRequests.addWhiteListEntry("https://*/*", false);
                } else {
                    access$200 = WhitelistPlugin.this.allowedRequests;
                    if (attributeValue3 == null || attributeValue3.compareToIgnoreCase("true") != 0) {
                        z = false;
                    }
                    access$200.addWhiteListEntry(attributeValue2, z);
                }
            }
        }

        public void handleEndTag(XmlPullParser xmlPullParser) {
        }
    }

    public WhitelistPlugin(Context context) {
        this(new Whitelist(), new Whitelist(), null);
        new CustomConfigXmlParser().parse(context);
    }

    public WhitelistPlugin(XmlPullParser xmlPullParser) {
        this(new Whitelist(), new Whitelist(), null);
        new CustomConfigXmlParser().parse(xmlPullParser);
    }

    public WhitelistPlugin(Whitelist whitelist, Whitelist whitelist2, Whitelist whitelist3) {
        if (whitelist3 == null) {
            whitelist3 = new Whitelist();
            whitelist3.addWhiteListEntry("file:///*", false);
            whitelist3.addWhiteListEntry("data:*", false);
        }
        this.allowedNavigations = whitelist;
        this.allowedIntents = whitelist2;
        this.allowedRequests = whitelist3;
    }

    public void pluginInitialize() {
        if (this.allowedNavigations == null) {
            this.allowedNavigations = new Whitelist();
            this.allowedIntents = new Whitelist();
            this.allowedRequests = new Whitelist();
            new CustomConfigXmlParser().parse(this.webView.getContext());
        }
    }

    public Boolean shouldAllowNavigation(String str) {
        if (this.allowedNavigations.isUrlWhiteListed(str)) {
            return Boolean.valueOf(true);
        }
        return null;
    }

    public Boolean shouldAllowRequest(String str) {
        if (Boolean.TRUE == shouldAllowNavigation(str)) {
            return Boolean.valueOf(true);
        }
        if (this.allowedRequests.isUrlWhiteListed(str)) {
            return Boolean.valueOf(true);
        }
        return null;
    }

    public Boolean shouldOpenExternalUrl(String str) {
        if (this.allowedIntents.isUrlWhiteListed(str)) {
            return Boolean.valueOf(true);
        }
        return null;
    }

    public Whitelist getAllowedNavigations() {
        return this.allowedNavigations;
    }

    public void setAllowedNavigations(Whitelist whitelist) {
        this.allowedNavigations = whitelist;
    }

    public Whitelist getAllowedIntents() {
        return this.allowedIntents;
    }

    public void setAllowedIntents(Whitelist whitelist) {
        this.allowedIntents = whitelist;
    }

    public Whitelist getAllowedRequests() {
        return this.allowedRequests;
    }

    public void setAllowedRequests(Whitelist whitelist) {
        this.allowedRequests = whitelist;
    }
}
