package com.fruityveggies.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.fruityveggies.www.service.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired OAuthLoginSuccessHandler oAuthLoginSuccessHandler;
    @Autowired OAuthLoginFailureHandler oAuthLoginFailureHandler;
    @Autowired UserService userService;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
        
//        http.authorizeRequests().requestMatchers("/**").hasRole("USER").and().formLogin()
//        .usernameParameter("username") // default is username
//        .passwordParameter("password") // default is password
//        .loginPage("/authentication/login") // default is /login with an HTTP get
//        .failureUrl("/authentication/login?failed") // default is /login?error
//        .loginProcessingUrl("/authentication/login/process"); // default is /login
//                                                                // with an HTTP
//                                                                // post
//        return http.build();
//
//        ;
        http
            .csrf((csrf) -> csrf.disable())
            .authorizeRequests(authorize -> authorize
                // 로그인 페이지는 누구나 접근 가능하게.
                .requestMatchers("/login/**").permitAll()
                .anyRequest().permitAll()
            )
            .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                    .userService(userService)
                    .and()
                .successHandler(oAuthLoginSuccessHandler)
                .failureHandler(oAuthLoginFailureHandler)
        .and() // 로그아웃 기능 활성화
        .logout()
            .logoutUrl("/logout") // 로그아웃 URL 설정
            .logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 URL 설정
            .invalidateHttpSession(true); // 세션 무효화 설정 (로그아웃 시 세션 삭제)
            
return http.build();
    }
}