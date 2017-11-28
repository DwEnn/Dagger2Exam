package example.dwenn.com.dagger2ex.daggerEx.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;

/**
 * Created by prgoh on 2017-11-28.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface UseMockBackend {
}
