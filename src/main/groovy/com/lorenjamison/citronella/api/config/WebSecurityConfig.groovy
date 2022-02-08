package com.lorenjamison.citronella.api.config


import com.lorenjamison.citronella.api.authentication.JwtAuthenticationEntryPoint
import com.lorenjamison.citronella.api.authentication.JwtFilter
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@CompileStatic
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtAuthenticationEntryPoint authenticationEntryPoint

    private UserDetailsService userDetailsService

    private JwtFilter jwtFilter

    @Autowired
    WebSecurityConfig(JwtAuthenticationEntryPoint authenticationEntryPoint,
                      UserDetailsService userDetailsService,
                      JwtFilter jwtFilter) {
        this.authenticationEntryPoint = authenticationEntryPoint
        this.userDetailsService = userDetailsService
        this.jwtFilter = jwtFilter
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        new BCryptPasswordEncoder()
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    @Override
    AuthenticationManager authenticationManagerBean() {
        super.authenticationManagerBean()
    }

    @Override
    protected void configure(HttpSecurity http) {
        http.csrf().disable()
                .authorizeRequests().antMatchers('/login').permitAll()
                .anyRequest().authenticated()
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter)
    }
}
