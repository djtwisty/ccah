package com.google.zxing.client.android.result;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.result.CalendarParsedResult;
import com.google.zxing.client.result.ParsedResult;
import java.text.DateFormat;
import java.util.Date;

public final class CalendarResultHandler extends ResultHandler {
    private static final String TAG = CalendarResultHandler.class.getSimpleName();
    private static final int[] buttons = new int[]{C0306R.string.button_add_calendar};

    public CalendarResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public void handleButtonPress(int i) {
        if (i == 0) {
            CalendarParsedResult calendarParsedResult = (CalendarParsedResult) getResult();
            String description = calendarParsedResult.getDescription();
            String organizer = calendarParsedResult.getOrganizer();
            if (organizer == null) {
                organizer = description;
            } else if (description != null) {
                organizer = description + '\n' + organizer;
            }
            addCalendarEvent(calendarParsedResult.getSummary(), calendarParsedResult.getStart(), calendarParsedResult.isStartAllDay(), calendarParsedResult.getEnd(), calendarParsedResult.getLocation(), organizer, calendarParsedResult.getAttendees());
        }
    }

    private void addCalendarEvent(String str, Date date, boolean z, Date date2, String str2, String str3, String[] strArr) {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.item/event");
        long time = date.getTime();
        intent.putExtra("beginTime", time);
        if (z) {
            intent.putExtra("allDay", true);
        }
        if (date2 != null) {
            time = date2.getTime();
        } else if (z) {
            time += 86400000;
        }
        intent.putExtra("endTime", time);
        intent.putExtra("title", str);
        intent.putExtra("eventLocation", str2);
        intent.putExtra("description", str3);
        if (strArr != null) {
            intent.putExtra("android.intent.extra.EMAIL", strArr);
        }
        try {
            rawLaunchIntent(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(TAG, "No calendar app available that responds to android.intent.action.INSERT");
            intent.setAction("android.intent.action.EDIT");
            launchIntent(intent);
        }
    }

    public CharSequence getDisplayContents() {
        CalendarParsedResult calendarParsedResult = (CalendarParsedResult) getResult();
        StringBuilder stringBuilder = new StringBuilder(100);
        ParsedResult.maybeAppend(calendarParsedResult.getSummary(), stringBuilder);
        Date start = calendarParsedResult.getStart();
        ParsedResult.maybeAppend(format(calendarParsedResult.isStartAllDay(), start), stringBuilder);
        Date end = calendarParsedResult.getEnd();
        if (end != null) {
            if (!calendarParsedResult.isEndAllDay() || start.equals(end)) {
                start = end;
            } else {
                start = new Date(end.getTime() - 86400000);
            }
            ParsedResult.maybeAppend(format(calendarParsedResult.isEndAllDay(), start), stringBuilder);
        }
        ParsedResult.maybeAppend(calendarParsedResult.getLocation(), stringBuilder);
        ParsedResult.maybeAppend(calendarParsedResult.getOrganizer(), stringBuilder);
        ParsedResult.maybeAppend(calendarParsedResult.getAttendees(), stringBuilder);
        ParsedResult.maybeAppend(calendarParsedResult.getDescription(), stringBuilder);
        return stringBuilder.toString();
    }

    private static String format(boolean z, Date date) {
        if (date == null) {
            return null;
        }
        DateFormat dateInstance;
        if (z) {
            dateInstance = DateFormat.getDateInstance(2);
        } else {
            dateInstance = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateInstance.format(date);
    }

    public int getDisplayTitle() {
        return C0306R.string.result_calendar;
    }
}
