package gyber.org.mainCore.config.security;

import gyber.org.mainCore.config.security.filter.CustomAuthenticationFilter;
import gyber.org.mainCore.config.security.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * Настройка по каким данным и откуда будет происходить авторизация и регистрация пользователя.
     * @param auth auth
     * @throws Exception exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        log.info("Method configureGlobal from SecurityConfig.class");

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    /**
     * Настройка безопасности url.
     * @param http http
     * @return build
     * @throws Exception exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("Method securityFilterChain from SecurityConfig.class");

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager(
                http.getSharedObject(AuthenticationConfiguration.class)));
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().requestMatchers("/api/login/**", "/api/token/refresh/**").permitAll();
        http.authorizeRequests().requestMatchers(GET, "/api/user/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().requestMatchers(POST, "/api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * Для аутентификации по токенам.
     * @param authenticationConfiguration authentication
     * @return authenticationManager
     * @throws Exception exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        log.info("Method authenticationManager from SecurityConfig.class");

        return authenticationConfiguration.getAuthenticationManager();
    }
}
