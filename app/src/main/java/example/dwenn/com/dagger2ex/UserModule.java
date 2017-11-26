package example.dwenn.com.dagger2ex;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prgoh on 2017-11-26.
 */

/*
    이 모듈은 유저와 관련된 협력자들을 제공한다.
    예를 보면, 유저의 사용사례들을 제공하고 있다.
 */

@Module
public class UserModule {

    @Provides @PerActivity GetUserListUseCase provideGetUserListUseCase(GetUserListUseCaseImpl getUserListUseCase) {
        return getUserListUseCase;
    }

    @Provides @PerActivity GetUserDetailsUseCase provideGetUserDetailsUseCase(GetUserDetailsUseCaseImpl getUserDetailsUseCase) {
        return getUserDetailsUseCase;
    }
}
