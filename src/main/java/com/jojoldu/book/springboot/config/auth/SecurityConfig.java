package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity//spring security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http    // h2-console화면을 사용하기 위해 해당 옵션들을 disable함.
                .csrf().disable()
                .headers().frameOptions().disable()
                // URL별 권한 관리를 설정하는 옵션의 시작점. authorizeRequests가 선언되어야만 antMatchers옵션 사용 가능
                .and()
                    .authorizeRequests()
                    .antMatchers("/","/css/**", "/images/**", "/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())//USER권한을 가진 사람만 열람 가능
                    .anyRequest().authenticated() //설정된 값들 이외의 나머지 URL들은 모두 인증된 사용자들(로그인한 사용자)에게만 허용.
                .and()
                    //로그아웃 성공 시 / 주소로 이동
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    //oauth2로그인 성공 이후 후속 조치를 진행할 userService 인터페이스의 구현체를 등록
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);

    }
}
