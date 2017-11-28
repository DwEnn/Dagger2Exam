package example.dwenn.com.dagger2ex.daggerEx;

import android.app.Application;

/**
 * Created by prgoh on 2017-11-28.
 */

public class DaggerDemoApplication extends Application {

    private static DaggerDemoGraph graph;
    private static DaggerDemoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        buildComponentAndInject();
    }

    public static DaggerDemoGraph component(){
        return graph;
    }

    public static void buildComponentAndInject(){

    }
}
