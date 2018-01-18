package ksuhaylia.coursedata.BackEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private AccessDeniedHandler accessDeniedHandler;

    private UserDetailsService userDetailsService;

    @Autowired
    public void setAccessDeniedHandler(AccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/signin",
                        "/postPage",
                        "/updateEvents",
                        "/updatePosts",
                        "/updateVideo",
                        "/updateTests",
                        "/updateNews",
                        "/showTests" ,
                        "/",
                        "/showThemes",
                        "/showRead",
                        "/showEvents",
                        "/authorizeUser",
                        "/resetPasswort",
                        "/checkPassword",
                        "/reset",
                        "/resetPassword/confirm",
                        "/checkEmail",
                        "/addUser/confirm",
                        "/sendCode"
                ).permitAll()
                .antMatchers("/changeUser",
                        "/checkRoleTest",
                        "/toTheRoleTest",
                        "/findBooks",
                        "/logout",
                        "/addPost",
                        "/showPrivateAccount",
                        "/showVideos",
                        "/showLibrary",
                        "/showInterakt",
                        "/createPost",
                        "/createNew").hasAnyRole("login")
                .antMatchers("/geograf").hasAnyRole("geolog")
                .antMatchers("/minerolog").hasAnyRole("minerolog")
                .antMatchers("/antropolog").hasAnyRole("antropolog")
                .antMatchers("/biolog").hasAnyRole("biolog")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}