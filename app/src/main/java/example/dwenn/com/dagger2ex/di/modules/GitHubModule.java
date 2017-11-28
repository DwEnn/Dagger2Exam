package example.dwenn.com.dagger2ex.di.modules;

import dagger.Module;
import dagger.Provides;
import example.dwenn.com.dagger2ex.di.scopes.UserScope;
import example.dwenn.com.dagger2ex.interfaces.GithubApiInterface;
import retrofit2.Retrofit;

/**
 * Created by prgoh on 2017-11-27.
 */

@Module
public class GitHubModule {

    @Provides
    @UserScope
    public GithubApiInterface providesGithubInterface(Retrofit retrofit){
        return retrofit.create(GithubApiInterface.class);
    }
}
