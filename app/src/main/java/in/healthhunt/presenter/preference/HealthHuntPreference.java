package in.healthhunt.presenter.preference;

import android.content.Context;
import android.content.SharedPreferences;

import in.healthhunt.R;

/**
 * Created by abhishekkumar on 4/27/18.
 */

public class HealthHuntPreference {

    private final static String pref = "healthhuntpref";

    public static void putString(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(pref,Context.MODE_PRIVATE);
        return sharedPref.getString(key, null);
    }

    public static void remove(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove(key);
        editor.commit();
    }

    public static void clear(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.commit();
    }
}