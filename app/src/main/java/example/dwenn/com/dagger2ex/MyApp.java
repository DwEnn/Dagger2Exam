package example.dwenn.com.dagger2ex;

import android.app.Application;

import example.dwenn.com.dagger2ex.di.component.DaggerGitHubComponent;
import example.dwenn.com.dagger2ex.di.component.DaggerNetComponent;
import example.dwenn.com.dagger2ex.di.component.GitHubComponent;
import example.dwenn.com.dagger2ex.di.component.NetComponent;
import example.dwenn.com.dagger2ex.di.modules.AppModule;
import example.dwenn.com.dagger2ex.di.modules.GitHubModule;
import example.dwenn.com.dagger2ex.di.modules.NetModule;

/**
 * Created by prgoh on 2017-11-27.
 */

public class MyApp extends Application {

    private NetComponent netComponent;
    private GitHubComponent gitHubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // specify the full namespace of the component
        // Dagger_xxx (where xxx = component name )
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();
        gitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(netComponent)
                .gitHubModule(new GitHubModule())
                .build();
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }

    public GitHubComponent getGitHubComponent(){
        return gitHubComponent;
    }
}
