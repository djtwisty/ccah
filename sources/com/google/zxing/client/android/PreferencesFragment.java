package com.google.zxing.client.android;

import android.app.AlertDialog.Builder;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

public final class PreferencesFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    private CheckBoxPreference[] checkBoxPrefs;

    private class CustomSearchURLValidator implements OnPreferenceChangeListener {
        private CustomSearchURLValidator() {
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (isValid(obj)) {
                return true;
            }
            Builder builder = new Builder(PreferencesFragment.this.getActivity());
            builder.setTitle(C0306R.string.msg_error);
            builder.setMessage(C0306R.string.msg_invalid_value);
            builder.setCancelable(true);
            builder.show();
            return false;
        }

        private boolean isValid(Object obj) {
            if (obj == null) {
                return true;
            }
            String obj2 = obj.toString();
            if (obj2.isEmpty()) {
                return true;
            }
            try {
                if (new URI(obj2.replaceAll("%[st]", "").replaceAll("%f(?![0-9a-f])", "")).getScheme() == null) {
                    return false;
                }
                return true;
            } catch (URISyntaxException e) {
                return false;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(C0306R.xml.preferences);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        preferenceScreen.getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        this.checkBoxPrefs = findDecodePrefs(preferenceScreen, PreferencesActivity.KEY_DECODE_1D_PRODUCT, PreferencesActivity.KEY_DECODE_1D_INDUSTRIAL, PreferencesActivity.KEY_DECODE_QR, PreferencesActivity.KEY_DECODE_DATA_MATRIX, PreferencesActivity.KEY_DECODE_AZTEC, PreferencesActivity.KEY_DECODE_PDF417);
        disableLastCheckedPref();
        ((EditTextPreference) preferenceScreen.findPreference(PreferencesActivity.KEY_CUSTOM_PRODUCT_SEARCH)).setOnPreferenceChangeListener(new CustomSearchURLValidator());
    }

    private static CheckBoxPreference[] findDecodePrefs(PreferenceScreen preferenceScreen, String... strArr) {
        CheckBoxPreference[] checkBoxPreferenceArr = new CheckBoxPreference[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            checkBoxPreferenceArr[i] = (CheckBoxPreference) preferenceScreen.findPreference(strArr[i]);
        }
        return checkBoxPreferenceArr;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        disableLastCheckedPref();
    }

    private void disableLastCheckedPref() {
        Object obj;
        Collection arrayList = new ArrayList(this.checkBoxPrefs.length);
        for (CheckBoxPreference checkBoxPreference : this.checkBoxPrefs) {
            if (checkBoxPreference.isChecked()) {
                arrayList.add(checkBoxPreference);
            }
        }
        if (arrayList.size() <= 1) {
            obj = 1;
        } else {
            obj = null;
        }
        for (CheckBoxPreference checkBoxPreference2 : this.checkBoxPrefs) {
            boolean z;
            if (obj == null || !arrayList.contains(checkBoxPreference2)) {
                z = true;
            } else {
                z = false;
            }
            checkBoxPreference2.setEnabled(z);
        }
    }
}
