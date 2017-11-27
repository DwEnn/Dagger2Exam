package example.dwenn.com.dagger2ex.di.component;

import dagger.Component;
import example.dwenn.com.dagger2ex.MainActivity;
import example.dwenn.com.dagger2ex.di.modules.GitHubModule;
import example.dwenn.com.dagger2ex.di.scopes.UserScope;

/**
 * Created by prgoh on 2017-11-27.
 */

@UserScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(MainActivity activity);
}
