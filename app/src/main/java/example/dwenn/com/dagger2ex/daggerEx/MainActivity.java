package example.dwenn.com.dagger2ex.daggerEx;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import example.dwenn.com.dagger2ex.daggerEx.data.UseMockBackend;
import example.dwenn.com.dagger2ex.daggerEx.data.prefs.BooleanPreference;

/**
 * Created by prgoh on 2017-11-28.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    @UseMockBackend
    BooleanPreference useMock;

    @Inject
    Resources resources;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
