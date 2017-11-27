package example.dwenn.com.dagger2ex.di.component;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import example.dwenn.com.dagger2ex.di.modules.AppModule;
import example.dwenn.com.dagger2ex.di.modules.NetModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by prgoh on 2017-11-27.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    //downstream components need these exposed
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}
