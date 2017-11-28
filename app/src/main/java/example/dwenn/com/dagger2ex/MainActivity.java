package example.dwenn.com.dagger2ex;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import java.util.ArrayList;

import javax.inject.Inject;

import example.dwenn.com.dagger2ex.di.modules.GitHubModule;
import example.dwenn.com.dagger2ex.interfaces.GithubApiInterface;
import example.dwenn.com.dagger2ex.models.Repository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by prgoh on 2017-11-27.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    Retrofit retrofit;
    @Inject
    GithubApiInterface githubApiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fba);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Call<ArrayList<Repository>> call = githubApiInterface.getRepository("codepath");


                call.enqueue(new Callback<ArrayList<Repository>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Repository>> call, Response<ArrayList<Repository>> response) {
                        if (response.isSuccessful()) {
                            Log.i("DEBUG", response.body().toString());
                            Snackbar.make(view, "Data retrieved", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else {
                            Log.i("ERROR", String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Repository>> call, Throwable t) {

                    }
                });
            }

        });

        // TODO: 2017-11-27 Caused by: java.lang.ClassCastException: android.app.Application cannot be cast to example.dwenn.com.dagger2ex.MyApp
//        ((MyApp) getApplication()).getGitHubComponent().inject(this);
        ((MyApp)getApplicationContext()).getGitHubComponent().inject(this);
    }
}