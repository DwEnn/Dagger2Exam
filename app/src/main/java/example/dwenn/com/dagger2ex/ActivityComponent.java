package example.dwenn.com.dagger2ex;

import android.app.Activity;

import dagger.Component;

/**
 * Created by prgoh on 2017-11-26.
 */

/**
 *  액티비티의 생명주기동안 살아있는 컴포넌트
 *
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
            modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
