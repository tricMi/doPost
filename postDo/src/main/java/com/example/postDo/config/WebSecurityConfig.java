package com.example.postDo.config;

import org.apache.catalina.Context;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.postDo.auth.RestAuthenticationEntryPoint;
import com.example.postDo.auth.TokenAuthenticationFilter;
import com.example.postDo.security.TokenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fan.jin on 2016-10-19.
 */

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig{

//	//Implementacija PasswordEncoder-a koriscenjem BCrypt hashing funkcije. 
//	//BCrypt po defalt-u radi 10 rundi hesiranja prosledjene vrednosti.
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    private com.example.postDo.service.CustomUserDetailsService jwtUserDetailsService;
//
//    //Neautorizovani pristup zastcenim resursima
//    @Autowired
//    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    
//    //Definisemo nacin autentifikacije
//    //Svaki 
//    @Autowired
//    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
//        auth.userDetailsService( jwtUserDetailsService )
//            .passwordEncoder( passwordEncoder() );
//    }
//
//    @Autowired
//    TokenHelper tokenHelper;
//
//    
//    //Definisemo prava pristupa odredjenim URL-ovima
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//        		//komunikacija izmedju klijenta i servera je stateless
//                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()
//                //za neautorizovane zahteve posalji 401 gresku
//                .exceptionHandling().authenticationEntryPoint( restAuthenticationEntryPoint ).and()
//                .authorizeRequests()
//                //svim korisnicima dopusti da pristupe putanjama /auth/**
//                .antMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/accounts").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/messages").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/rules").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/tags").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/contacts").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/folders").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/messages/{id}").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/rules/{id}").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/tags/{id}").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/contacts/{id}").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/folders/{id}").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/messages/{id}").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/rules/{id}").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/tags/{id}").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/contacts/{id}").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/folders/{id}").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/messages/{id}").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/rules/{id}").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/tags/{id}").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/contacts/{id}").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/folders/{id}").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/rules").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/tags").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/contacts").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/folders").permitAll()
//                
//                //svaki zahtev mora biti autorizovan
//                .anyRequest().authenticated().and()
//                //presretni svaki zahtev filterom
//                .addFilterBefore(new TokenAuthenticationFilter(tokenHelper, jwtUserDetailsService), BasicAuthenticationFilter.class);
//
//        http.csrf().disable();
//    }
//
//
//    //Generalna bezbednost aplikacije
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // TokenAuthenticationFilter ce ignorisati sve ispod navedene putanje
//        web.ignoring().antMatchers(
//                HttpMethod.POST,
//                "api/auth/login"
//        );
//        web.ignoring().antMatchers(
//                HttpMethod.GET,
//                "/",
//                "/webjars/**",
//                "/*.html",
//                "/favicon.ico",
//                "/**/*.html",
//                "/**/*.css",
//                "/**/*.js"
//            );
//
//    }
   
}
