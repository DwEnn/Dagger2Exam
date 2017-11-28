package example.dwenn.com.dagger2ex.daggerEx.data.prefs;

import android.content.SharedPreferences;

/**
 * Created by prgoh on 2017-11-28.
 */

public class BooleanPreference {

    private final SharedPreferences sharedPreferences;
    private final String key;
    private final boolean defaultValue;

    public BooleanPreference(SharedPreferences sharedPreferences, String key) {
        this(sharedPreferences, key, false);
    }

    public BooleanPreference(SharedPreferences sharedPreferences, String key, boolean defaultValue) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public boolean get(){
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public boolean isSet(){
        return sharedPreferences.contains(key);
    }

    public void set(boolean value){
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void delete(){
        sharedPreferences.edit().remove(key).apply();
    }
}
