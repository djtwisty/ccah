package org.apache.http.impl.cookie;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.SetCookie;

@Deprecated
public class RFC2965PortAttributeHandler implements CookieAttributeHandler {
    public RFC2965PortAttributeHandler() {
        throw new RuntimeException("Stub!");
    }

    public void parse(SetCookie setCookie, String str) {
        throw new RuntimeException("Stub!");
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }
}
