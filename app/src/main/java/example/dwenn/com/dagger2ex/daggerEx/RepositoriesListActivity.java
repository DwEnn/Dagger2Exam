package example.dwenn.com.dagger2ex.daggerEx;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import example.dwenn.com.dagger2ex.daggerEx.api.GitHubService;
import example.dwenn.com.dagger2ex.daggerEx.api.model.Repository;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by prgoh on 2017-11-28.
 */

public class RepositoriesListActivity extends ListActivity {

    @Inject
    GitHubService gitHubService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerDemoApplication.component().inject(this);

        loadData();
    }

    private void loadData(){
        gitHubService.listRepos("phajduk")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Repository>>() {
                    @Override
                    public void call(List<Repository> repositories) {
                        List<String> names = new ArrayList<>();
                        for (Repository repository : repositories)
                            names.add(repository.name);

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RepositoriesListActivity.this,
                                android.R.layout.simple_list_item_1, names);
                        setListAdapter(adapter);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("RepositoriesList", "Error receiving");
                    }
                });
    }
}
