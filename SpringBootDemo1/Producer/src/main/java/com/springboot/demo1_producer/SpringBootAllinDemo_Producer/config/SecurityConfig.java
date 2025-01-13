package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//"/api/orders/**",

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                .csrf(csrf -> csrf.disable())
                .csrf(Customizer.withDefaults()) // Enable CSRF protection. when enabling this, make sure to enable csrf hidden fields in all html files
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/register", "/login", "/logout", "/api/register", "/check-session", "/api/orders/csrf").permitAll()
                        .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider())
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                )
//                .formLogin(Customizer.withDefaults())
                .formLogin(form -> form
                                .disable()
//                                .loginPage("/login") // URL for your custom login page
//                                .loginProcessingUrl("/login") // URL to process the login form submission
//                                .usernameParameter("username") // The name attribute of your username field in the form
//                                .passwordParameter("password") // The name attribute of your password field in the form
//                                .defaultSuccessUrl("/", true) // Redirect after successful login
//                                .failureUrl("/login?error=true") // Redirect after failed login
//                                .permitAll()
                )
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .deleteCookies("JSESSIONID", "JWT")
                                .logoutSuccessUrl("/login?logout=true")
                                .permitAll()
                )
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                )
                .httpBasic(Customizer.withDefaults()) // enable this for stateless auth and pass username password via basic auth in postman.
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails sarath = User.withUsername("sarath")
//                                .password("{noop}sarath")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(sarath);
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(14);
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }
//
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}