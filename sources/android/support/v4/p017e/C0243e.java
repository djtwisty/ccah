package android.support.v4.p017e;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.e.e */
public class C0243e extends Writer {
    /* renamed from: a */
    private final String f483a;
    /* renamed from: b */
    private StringBuilder f484b = new StringBuilder(128);

    public C0243e(String str) {
        this.f483a = str;
    }

    public void close() {
        m750a();
    }

    public void flush() {
        m750a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m750a();
            } else {
                this.f484b.append(c);
            }
        }
    }

    /* renamed from: a */
    private void m750a() {
        if (this.f484b.length() > 0) {
            Log.d(this.f483a, this.f484b.toString());
            this.f484b.delete(0, this.f484b.length());
        }
    }
}
