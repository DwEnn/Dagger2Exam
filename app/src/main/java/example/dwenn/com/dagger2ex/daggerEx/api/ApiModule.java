package example.dwenn.com.dagger2ex.daggerEx.api;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.dwenn.com.dagger2ex.daggerEx.data.DataModule;
import okhttp3.OkHttpClient;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;

/**
 * Created by prgoh on 2017-11-28.
 */

@Module
public class ApiModule {
    public static final String PRODUCTION_API_URL = "https://api.github.com";

//    @Provides
//    @Singleton
//    Client provideClient(Application application){
//        return new OkClient(DataModule.createOkHttpClient(application));
//    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(Endpoint endpoint, Client client){
        return new RestAdapter.Builder()
                .setClient(client).setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(endpoint).build();
    }
}
