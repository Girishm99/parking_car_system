package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new SettingActivity.MainSettingsFragment()).commit();
    }
    public static class MainSettingsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settingpreference);

            bindSummaryValue(findPreference("key_full_name"));
            bindSummaryValue(findPreference("pref_syncConnectionType"));
            bindSummaryValue(findPreference("key_email"));
            bindSummaryValue(findPreference("key_sleep_timer"));
            bindSummaryValue(findPreference("key_notification_ringtone"));

        }
    }

    private static void bindSummaryValue(Preference preference){
        preference.setOnPreferenceChangeListener(listener);
        listener.onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(),""));
    }

    private static Preference.OnPreferenceChangeListener listener=new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String values=newValue.toString();
            if (preference instanceof ListPreference){
                ListPreference listPreference=(ListPreference) preference;

                int index=listPreference.findIndexOfValue(values);
                preference.setSummary(index > 0
                        ? listPreference.getEntries()[index] :null);

            }else if (preference instanceof EditTextPreference){
                preference.setSummary(values);

            }else if (preference instanceof RingtonePreference){
                if (TextUtils.isEmpty(values)){
                    preference.setSummary("silent");
                }else {
                    Ringtone ringtone= RingtoneManager.getRingtone(preference.getContext(), Uri.parse(values));

                    if (ringtone == null){
                        preference.setSummary("choose notification ringtone");
                    }else {
                        String name=ringtone.getTitle(preference.getContext());
                        preference.setSummary(name);
                    }
                }
            }
            return true;
        }
    };
}
