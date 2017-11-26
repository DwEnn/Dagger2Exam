package example.dwenn.com.dagger2ex;

import dagger.Component;

/**
 * Created by prgoh on 2017-11-26.
 */

/**
 *  ActivityComponent 를 상속하고 @PerActivity 스코프에서
 *  작동하는 컴포넌트.
 *
 *  유저와 관련된 프래그먼트들에게 객체들을 주입하기 위해 사용.
 *
 *  ActivityModule이 액티비티를 그래프에 제공하기 때문에, 의존성을 만족하기
 *  위해 액티비티 컨텍스트 필요할 때마다 Dagger 가 ActivityModule 로 부터
 *  컨텍스트를 가져와 주입해준다.
 *
 *  즉, 하위 모듈에 액티비티를 재정의할 필요가 없다.
 *
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {
            ActivityModule.class, UserModule.class
        })

public interface UserComponent extends ActivityComponent {
    void inject(UserListFragment userListFragment);
    void inject(UserDetailsFragment userDetailsFragment);
}
