package kr.semanticker.projectboard.config;

import kr.semanticker.projectboard.dto.UserAccountDto;
import kr.semanticker.projectboard.dto.security.BoardPrincipal;
import kr.semanticker.projectboard.repository.UserAccountRepository;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        //auth -> auth.anyRequest().permitAll()
                        auth -> auth
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .requestMatchers(
                                    HttpMethod.GET,
                                    "/",
                                    "/articles",
                                    "/articles/search-hashtag"
                                ).permitAll().anyRequest().authenticated()
                )
                .formLogin()
                    .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .and()
                .build();
    }

    /* securityFilterChain 에서 permitAll 처리
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // static resources => css, js
        return (web) -> web.ignoring().requestMatchers( PathRequest.toStaticResources().atCommonLocations());
    }
    */

    @Bean
    public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
        return username -> userAccountRepository
                .findById(username)
                .map(UserAccountDto::from)
                .map(BoardPrincipal::from)
                .orElseThrow(()-> new UsernameNotFoundException("유저를 찾을 수 없습니다. - username: " + username));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
