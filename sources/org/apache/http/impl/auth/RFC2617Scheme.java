package org.apache.http.impl.auth;

import java.util.Map;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract class RFC2617Scheme extends AuthSchemeBase {
    public RFC2617Scheme() {
        throw new RuntimeException("Stub!");
    }

    protected void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    protected Map<String, String> getParameters() {
        throw new RuntimeException("Stub!");
    }

    public String getParameter(String str) {
        throw new RuntimeException("Stub!");
    }

    public String getRealm() {
        throw new RuntimeException("Stub!");
    }
}
