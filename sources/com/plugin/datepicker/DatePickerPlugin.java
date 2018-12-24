package com.plugin.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class DatePickerPlugin extends CordovaPlugin {
    /* renamed from: a */
    private final String f758a = "DatePickerPlugin";
    /* renamed from: b */
    private boolean f759b = false;
    /* renamed from: c */
    private boolean f760c = false;
    /* renamed from: d */
    private TimePicker f761d;
    /* renamed from: e */
    private int f762e = 0;
    /* renamed from: f */
    private int f763f = 0;

    /* renamed from: com.plugin.datepicker.DatePickerPlugin$a */
    private final class C0472a implements OnDateSetListener {
        /* renamed from: a */
        final /* synthetic */ DatePickerPlugin f735a;
        /* renamed from: b */
        private C0473b f736b;
        /* renamed from: c */
        private final DatePickerPlugin f737c;
        /* renamed from: d */
        private final CallbackContext f738d;
        /* renamed from: e */
        private final int f739e;

        private C0472a(DatePickerPlugin datePickerPlugin, DatePickerPlugin datePickerPlugin2, int i, CallbackContext callbackContext, C0473b c0473b) {
            this.f735a = datePickerPlugin;
            this.f737c = datePickerPlugin2;
            this.f738d = callbackContext;
            this.f736b = c0473b;
            this.f739e = i;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            if (!this.f735a.f760c && !this.f735a.f759b) {
                this.f735a.f759b = true;
                this.f735a.f760c = false;
                Log.d("onDateSet", "called: " + this.f735a.f759b);
                Log.d("onDateSet", "canceled: " + this.f735a.f760c);
                Log.d("onDateSet", "mode: " + this.f736b.f741b);
                if ("date".equalsIgnoreCase(this.f736b.f741b)) {
                    String str = i + "/" + (i2 + 1) + "/" + i3;
                    Log.d("onDateSet", "returnDate: " + str);
                    this.f738d.success(str);
                    return;
                }
                Calendar instance = Calendar.getInstance();
                instance.set(1, i);
                instance.set(2, i2);
                instance.set(5, i3);
                this.f735a.cordova.getActivity().runOnUiThread(this.f735a.m1182a(this.f737c, this.f739e, this.f735a.cordova.getActivity(), this.f738d, this.f736b, instance));
            }
        }
    }

    /* renamed from: com.plugin.datepicker.DatePickerPlugin$b */
    private final class C0473b {
        /* renamed from: a */
        final /* synthetic */ DatePickerPlugin f740a;
        /* renamed from: b */
        private String f741b = "date";
        /* renamed from: c */
        private String f742c = "";
        /* renamed from: d */
        private String f743d = "";
        /* renamed from: e */
        private String f744e = "";
        /* renamed from: f */
        private String f745f = "";
        /* renamed from: g */
        private String f746g = "";
        /* renamed from: h */
        private long f747h = 0;
        /* renamed from: i */
        private long f748i = 0;
        /* renamed from: j */
        private int f749j = 0;
        /* renamed from: k */
        private int f750k = 0;
        /* renamed from: l */
        private int f751l = 0;
        /* renamed from: m */
        private int f752m = 0;
        /* renamed from: n */
        private int f753n = 0;
        /* renamed from: o */
        private boolean f754o = false;

        public C0473b(DatePickerPlugin datePickerPlugin) {
            this.f740a = datePickerPlugin;
            m1162a(Calendar.getInstance());
        }

        /* renamed from: a */
        private void m1162a(Calendar calendar) {
            this.f751l = calendar.get(1);
            this.f749j = calendar.get(2);
            this.f750k = calendar.get(5);
            this.f752m = calendar.get(11);
            this.f753n = calendar.get(12);
        }

        /* renamed from: a */
        public C0473b m1176a(JSONArray jSONArray) {
            long j = 0;
            boolean z = false;
            try {
                long j2;
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                this.f741b = m1177a(jSONObject, "mode") ? jSONObject.getString("mode") : "date";
                if (m1177a(jSONObject, "minDate")) {
                    j2 = jSONObject.getLong("minDate");
                } else {
                    j2 = 0;
                }
                this.f747h = j2;
                if (m1177a(jSONObject, "maxDate")) {
                    j = jSONObject.getLong("maxDate");
                }
                this.f748i = j;
                this.f742c = m1177a(jSONObject, "titleText") ? jSONObject.getString("titleText") : "";
                this.f743d = m1177a(jSONObject, "okText") ? jSONObject.getString("okText") : "";
                this.f744e = m1177a(jSONObject, "cancelText") ? jSONObject.getString("cancelText") : "";
                this.f745f = m1177a(jSONObject, "todayText") ? jSONObject.getString("todayText") : "";
                this.f746g = m1177a(jSONObject, "nowText") ? jSONObject.getString("nowText") : "";
                if (m1177a(jSONObject, "is24Hour")) {
                    z = jSONObject.getBoolean("is24Hour");
                }
                this.f754o = z;
                String[] split = jSONObject.getString("date").split("/");
                this.f749j = Integer.parseInt(split[0]) - 1;
                this.f750k = Integer.parseInt(split[1]);
                this.f751l = Integer.parseInt(split[2]);
                this.f752m = Integer.parseInt(split[3]);
                this.f753n = Integer.parseInt(split[4]);
            } catch (JSONException e) {
                m1162a(Calendar.getInstance());
            }
            return this;
        }

        /* renamed from: a */
        public boolean m1177a(JSONObject jSONObject, String str) {
            return jSONObject.has(str) && !jSONObject.isNull(str) && jSONObject.get(str).toString().length() > 0 && !JSONObject.NULL.toString().equals(jSONObject.get(str).toString());
        }
    }

    /* renamed from: com.plugin.datepicker.DatePickerPlugin$c */
    private final class C0474c implements OnTimeSetListener {
        /* renamed from: a */
        final /* synthetic */ DatePickerPlugin f755a;
        /* renamed from: b */
        private Calendar f756b;
        /* renamed from: c */
        private final CallbackContext f757c;

        private C0474c(DatePickerPlugin datePickerPlugin, DatePickerPlugin datePickerPlugin2, CallbackContext callbackContext, Calendar calendar) {
            this.f755a = datePickerPlugin;
            this.f757c = callbackContext;
            if (calendar == null) {
                calendar = Calendar.getInstance();
            }
            this.f756b = calendar;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (!this.f755a.f760c) {
                this.f756b.set(11, i);
                this.f756b.set(12, i2);
                this.f756b.set(13, 0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                this.f757c.success(simpleDateFormat.format(this.f756b.getTime()));
            }
        }
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        Log.d("DatePickerPlugin", "DatePicker called with options: " + jSONArray);
        this.f759b = false;
        this.f760c = false;
        m1193a(jSONArray, callbackContext);
        return true;
    }

    /* renamed from: a */
    public synchronized void m1193a(JSONArray jSONArray, CallbackContext callbackContext) {
        Runnable a;
        Context activity = this.cordova.getActivity();
        C0473b a2 = new C0473b(this).m1176a(jSONArray);
        int optInt = jSONArray.optJSONObject(0).optInt("androidTheme", 1);
        if ("time".equalsIgnoreCase(a2.f741b)) {
            a = m1182a(this, optInt, activity, callbackContext, a2, Calendar.getInstance(TimeZone.getDefault()));
        } else {
            a = m1181a(this, optInt, activity, callbackContext, a2);
        }
        this.cordova.getActivity().runOnUiThread(a);
    }

    /* renamed from: a */
    private Runnable m1182a(DatePickerPlugin datePickerPlugin, int i, Context context, CallbackContext callbackContext, C0473b c0473b, Calendar calendar) {
        final DatePickerPlugin datePickerPlugin2 = datePickerPlugin;
        final CallbackContext callbackContext2 = callbackContext;
        final Calendar calendar2 = calendar;
        final Context context2 = context;
        final int i2 = i;
        final C0473b c0473b2 = c0473b;
        return new Runnable(this) {
            /* renamed from: g */
            final /* synthetic */ DatePickerPlugin f712g;

            /* renamed from: com.plugin.datepicker.DatePickerPlugin$1$3 */
            class C04653 implements OnClickListener {
                /* renamed from: a */
                final /* synthetic */ C04661 f705a;

                C04653(C04661 c04661) {
                    this.f705a = c04661;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f705a.f712g.f760c = true;
                    callbackContext2.error("cancel");
                }
            }

            public void run() {
                final C0474c c0474c = new C0474c(datePickerPlugin2, callbackContext2, calendar2);
                TimePickerDialog c04631 = new TimePickerDialog(this, context2, i2, c0474c, c0473b2.f752m, c0473b2.f753n, c0473b2.f754o) {
                    /* renamed from: a */
                    final /* synthetic */ C04661 f702a;

                    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
                        this.f702a.f712g.f761d = timePicker;
                        this.f702a.f712g.f762e = i;
                        this.f702a.f712g.f763f = i2;
                    }
                };
                if (VERSION.SDK_INT >= 11) {
                    c04631.setCancelable(true);
                    c04631.setCanceledOnTouchOutside(false);
                    if (!c0473b2.f742c.isEmpty()) {
                        c04631.setTitle(c0473b2.f742c);
                    }
                    if (!c0473b2.f746g.isEmpty()) {
                        c04631.setButton(-3, c0473b2.f746g, new OnClickListener(this) {
                            /* renamed from: b */
                            final /* synthetic */ C04661 f704b;

                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (this.f704b.f712g.f761d != null) {
                                    Calendar instance = Calendar.getInstance();
                                    c0474c.onTimeSet(this.f704b.f712g.f761d, instance.get(11), instance.get(12));
                                }
                            }
                        });
                    }
                    c04631.setButton(-2, c0473b2.f744e.isEmpty() ? context2.getString(17039360) : c0473b2.f744e, new C04653(this));
                    c04631.setButton(-1, c0473b2.f743d.isEmpty() ? context2.getString(17039370) : c0473b2.f743d, c04631);
                }
                c04631.show();
                c04631.updateTime(new Random().nextInt(23), new Random().nextInt(59));
                c04631.updateTime(c0473b2.f752m, c0473b2.f753n);
            }
        };
    }

    /* renamed from: a */
    private Runnable m1181a(DatePickerPlugin datePickerPlugin, int i, Context context, CallbackContext callbackContext, C0473b c0473b) {
        final DatePickerPlugin datePickerPlugin2 = datePickerPlugin;
        final int i2 = i;
        final CallbackContext callbackContext2 = callbackContext;
        final C0473b c0473b2 = c0473b;
        final Context context2 = context;
        return new Runnable(this) {
            /* renamed from: f */
            final /* synthetic */ DatePickerPlugin f718f;

            public void run() {
                C0472a c0472a = new C0472a(datePickerPlugin2, i2, callbackContext2, c0473b2);
                DatePickerDialog datePickerDialog = new DatePickerDialog(context2, i2, c0472a, c0473b2.f751l, c0473b2.f749j, c0473b2.f750k);
                if (VERSION.SDK_INT >= 11) {
                    this.f718f.m1184a(datePickerDialog, (OnDateSetListener) c0472a, callbackContext2, context2, c0473b2);
                } else {
                    this.f718f.m1185a(datePickerDialog, callbackContext2, context2, c0473b2);
                }
                datePickerDialog.show();
            }
        };
    }

    /* renamed from: a */
    private void m1184a(final DatePickerDialog datePickerDialog, final OnDateSetListener onDateSetListener, final CallbackContext callbackContext, Context context, C0473b c0473b) {
        datePickerDialog.setCancelable(true);
        datePickerDialog.setCanceledOnTouchOutside(false);
        if (!c0473b.f742c.isEmpty()) {
            datePickerDialog.setTitle(c0473b.f742c);
        }
        if (!c0473b.f745f.isEmpty()) {
            datePickerDialog.setButton(-3, c0473b.f745f, new OnClickListener(this) {
                /* renamed from: c */
                final /* synthetic */ DatePickerPlugin f721c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    Calendar instance = Calendar.getInstance();
                    onDateSetListener.onDateSet(datePickerDialog.getDatePicker(), instance.get(1), instance.get(2), instance.get(5));
                }
            });
        }
        datePickerDialog.setButton(-2, c0473b.f744e.isEmpty() ? context.getString(17039360) : c0473b.f744e, new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ DatePickerPlugin f723b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f723b.f760c = true;
                callbackContext.error("cancel");
            }
        });
        datePickerDialog.setButton(-1, c0473b.f743d.isEmpty() ? context.getString(17039370) : c0473b.f743d, new OnClickListener(this) {
            /* renamed from: c */
            final /* synthetic */ DatePickerPlugin f726c;

            public void onClick(DialogInterface dialogInterface, int i) {
                DatePicker datePicker = datePickerDialog.getDatePicker();
                datePicker.clearFocus();
                onDateSetListener.onDateSet(datePicker, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
            }
        });
        DatePicker datePicker = datePickerDialog.getDatePicker();
        if (c0473b.f747h > 0) {
            datePicker.setMinDate(c0473b.f747h);
        }
        if (c0473b.f748i > 0 && c0473b.f748i > c0473b.f747h) {
            datePicker.setMaxDate(c0473b.f748i);
        }
    }

    /* renamed from: a */
    private void m1185a(DatePickerDialog datePickerDialog, CallbackContext callbackContext, Context context, C0473b c0473b) {
        DatePicker datePicker;
        Field field = null;
        try {
            field = datePickerDialog.getClass().getDeclaredField("mDatePicker");
        } catch (NoSuchFieldException e) {
            callbackContext.error("error");
        }
        field.setAccessible(true);
        try {
            datePicker = (DatePicker) field.get(datePickerDialog);
        } catch (IllegalArgumentException e2) {
            callbackContext.error("error");
            datePicker = null;
        } catch (IllegalAccessException e3) {
            callbackContext.error("error");
            datePicker = null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(c0473b.f747h);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(c0473b.f748i);
        final int i = instance.get(1);
        final int i2 = instance.get(2);
        final int i3 = instance.get(5);
        final int i4 = instance2.get(1);
        final int i5 = instance2.get(2);
        final int i6 = instance2.get(5);
        if (instance != null || instance2 != null) {
            final C0473b c0473b2 = c0473b;
            datePicker.init(c0473b.f751l, c0473b.f749j, c0473b.f750k, new OnDateChangedListener(this) {
                /* renamed from: h */
                final /* synthetic */ DatePickerPlugin f734h;

                public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
                    if (c0473b2.f748i > 0 && c0473b2.f748i > c0473b2.f747h && (i > i4 || ((i2 > i5 && i == i4) || (i3 > i6 && i == i4 && i2 == i5)))) {
                        datePicker.updateDate(i4, i5, i6);
                    }
                    if (c0473b2.f747h <= 0) {
                        return;
                    }
                    if (i < i || ((i2 < i2 && i == i) || (i3 < i3 && i == i && i2 == i2))) {
                        datePicker.updateDate(i, i2, i3);
                    }
                }
            });
        }
    }
}
