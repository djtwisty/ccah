package com.yourvoice.ccApp.androidcomponent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: com.yourvoice.ccApp.androidcomponent.c */
public class C0484c {
    /* renamed from: a */
    public static Date m1243a(String str) {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat.setCalendar(instance);
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static long m1242a(Date date, Date date2) {
        return Math.abs((date2.getTime() / 1000) - (date.getTime() / 1000)) / 60;
    }
}
