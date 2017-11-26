package example.dwenn.com.dagger2ex;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prgoh on 2017-11-26.
 */

/**
 *  이 모듈은 그래프의 자손들에게 액티비티를 제공한다.
 *  예를 들어, 프래그먼트에서 액티비티 컨텍스트를 사용한다.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Activity getActivity() {
        return activity;
    }
}
