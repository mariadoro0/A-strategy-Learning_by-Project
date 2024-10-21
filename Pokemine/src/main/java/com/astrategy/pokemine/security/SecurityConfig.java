package com.astrategy.pokemine.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.astrategy.pokemine.services.UsersServiceImpl;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig{

    @Autowired
    private UsersServiceImpl userDetailService; 

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

    return httpSecurity
    		.csrf(AbstractHttpConfigurer::disable)
    		.authorizeHttpRequests(authorize -> {
                      authorize.requestMatchers("cards/**", "/users/**"/*,"collection/**","decks/**"*/).permitAll();
                      authorize.requestMatchers("/cards/**","/decks/**").hasRole("USER");
                      authorize.anyRequest().authenticated();
                      })
            .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
            //this part for thymeleaf auth with page
    	//	.formLogin((form)->
    		//	form.loginPage("/login")
    		// .permitAll() // Allow everyone to access the login page
           //  .defaultSuccessUrl("/home", true) // Redirect to /home after successful login
    // )
    		
            .build();

  }
   
  @Bean
  public UserDetailsService userDetailsService(){
  
        return userDetailService; //class da fare 
  }
  @Bean
  public  AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
      provider.setUserDetailsService(userDetailService);
      provider.setPasswordEncoder(passwordEncoder());
      return provider;
  }
  @Bean
  public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
  }
}
