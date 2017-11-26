package example.dwenn.com.dagger2ex;

import dagger.Component;

/**
 * Created by prgoh on 2017-11-26.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
            modules = ActivityModule.class)
public interface ActivityComponent {

}
