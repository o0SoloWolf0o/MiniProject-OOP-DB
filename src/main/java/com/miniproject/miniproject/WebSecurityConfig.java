package com.miniproject.miniproject;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
				.antMatchers("/users").hasAnyAuthority("Admin")
				.antMatchers("/users/**").hasAnyAuthority("Admin")
				.antMatchers("/request/new").hasAnyAuthority("Admin")
				.antMatchers("/request/edit/**").hasAnyAuthority("Admin")
				.antMatchers("/request/delete/**").hasAuthority("Admin")
				.anyRequest().authenticated()
            .and()
            	.formLogin().permitAll()
            .and()
            	.logout().logoutSuccessUrl("/").permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			;
    }
}
