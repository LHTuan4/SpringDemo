package org.shoppingdemon.config;

import org.shoppingdemon.authentication.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
   @Autowired
   MyDBAuthenticationService myDBAauthenticationService;
 
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
    
       // User Database
       auth.userDetailsService(myDBAauthenticationService);
 
   }
 
   @Override
   protected void configure(HttpSecurity http) throws Exception {
 
       http.csrf().disable();
 
       http.authorizeRequests().antMatchers("/orderList","/order", "/accountInfo")//
               .access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");
 
  
       //  MANAGER
       http.authorizeRequests().antMatchers("/product").access("hasRole('ROLE_MANAGER')");
 
  
       
       // AccessDeniedException .
       http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
  
       //Login Form.
       http.authorizeRequests().and().formLogin()//
          
               // URL login
               .loginProcessingUrl("/j_spring_security_check") // Submit URL
               .loginPage("/login")//
               .defaultSuccessUrl("/accountInfo")//
               .failureUrl("/login?error=true")//
               .usernameParameter("userName")//
               .passwordParameter("password")
            
               // Logout Page.

               .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
 
   }
}