package example.dwenn.com.dagger2ex.daggerEx.api;

import java.util.List;
import java.util.Observable;

import example.dwenn.com.dagger2ex.daggerEx.api.model.Repository;
import retrofit.http.Headers;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by prgoh on 2017-11-28.
 */

public interface GitHubService {
    @GET("/users/{user}/repos")
    @Headers("User-Agent : DaggerDemo")
    rx.Observable<List<Repository>> listRepos(
            @Path("user") String user
    );
}
