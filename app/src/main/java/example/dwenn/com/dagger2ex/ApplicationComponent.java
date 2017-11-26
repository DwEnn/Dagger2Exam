package example.dwenn.com.dagger2ex;

import android.content.Context;

import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by prgoh on 2017-11-26.
 */

/**
 *  어플리케이션의 수명이 컴포넌트의 수명
 *  이것은 AndroidApplication 와 MainActivity 모두에 주입된다
 */
@Singleton
@Component(modules = {
        ApplicationModule.class
})

public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
