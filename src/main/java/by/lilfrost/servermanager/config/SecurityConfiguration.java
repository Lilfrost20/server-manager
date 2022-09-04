package by.lilfrost.servermanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private static final String SUCCESS_URL = "/api/v1/servers";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(config-> config
                        .anyRequest().authenticated()
                        .antMatchers("/api/v1/auth/login","/api/v1/auth/registration").permitAll())
                .formLogin(config -> config
                        .defaultSuccessUrl(SUCCESS_URL))
                .oauth2Login(config -> config
                        .defaultSuccessUrl(SUCCESS_URL));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
