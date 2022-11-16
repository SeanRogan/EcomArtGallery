package dev.seanrogan.gallery.security;

import dev.seanrogan.gallery.security.filter.AuthenticationFilter;
import dev.seanrogan.gallery.security.filter.AuthorizationFilter;
import dev.seanrogan.gallery.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthenticationFilter filter = new AuthenticationFilter(authenticationManagerBean());
        filter.setFilterProcessesUrl("");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http
                //Todo this needs to be done, right now everything is open
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .and()
                .httpBasic();
     http.addFilter(filter);
     http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();

    }
}
