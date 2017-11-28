package example.dwenn.com.dagger2ex.daggerEx.data;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.dwenn.com.dagger2ex.daggerEx.data.prefs.BooleanPreference;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by prgoh on 2017-11-28.
 */

@Module
public class DataModule {
    static final int DISK_CACHE_SIEZ = 50 * 1024 * 1024; // 50MB

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("daggerdemo", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    @UseMockBackend
    BooleanPreference provideUseMockBackend(SharedPreferences sharedPreferences){
        return new BooleanPreference(sharedPreferences, "use_mock", false);
    }

    public static OkHttpClient createOkHttpClient(Application application) {

        // Install an HTTP cache in the application cache directory.
        File cacheDir = new File(application.getCacheDir(), "http");

        Cache cache = new Cache(cacheDir, DISK_CACHE_SIEZ);

        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache).build();

        return client;
    }
}
