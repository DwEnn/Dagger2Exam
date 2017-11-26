package example.dwenn.com.dagger2ex;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * Created by prgoh on 2017-11-26.
 */

/**
 * @PerActivity 객체의 수명이 액티비티의 수명을 따를 경우 사용하는
 *      사용자 정의 스코프 어노테이션.
 *
 *      다음과 같은 장점들을 가진다
 *          - 액티비티가 생성되어있길 요구하는 부분에 객체 인젝트
 *          - 액티비티 기반의 싱글톤 객체 사용
 *          - 액티비티에서만 사용하는 것을 글로벌 객체 그래프와 분리
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity { }
