package example.dwenn.com.dagger2ex.interfaces;

import java.util.ArrayList;

import example.dwenn.com.dagger2ex.models.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by prgoh on 2017-11-27.
 */

public interface GithubApiInterface {

    @GET("/users/{user}/repos")
    Call<ArrayList<Repository>> getRepository(
            @Path("user") String userName
    );

}
