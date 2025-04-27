package com.diu.labinventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/inventory/admin/login", "/inventory/admin/logout").permitAll()
						.requestMatchers("/inventory/admin/**").authenticated()
						.anyRequest().permitAll()
				)
				.formLogin(form -> form
						.loginPage("/inventory/admin/login")
						.loginProcessingUrl("/inventory/admin/login")
						.defaultSuccessUrl("/inventory/admin/dashboard", true)
						.failureUrl("/inventory/admin/login?error")
						.permitAll()
				)
				.logout(logout -> logout
						.logoutUrl("/inventory/admin/logout")
						.logoutSuccessUrl("/inventory/admin/login?logout")
						.permitAll()
				)
				.sessionManagement(session -> session
						.invalidSessionUrl("/inventory/admin/login")
						.maximumSessions(1)
						.expiredUrl("/inventory/admin/login?expired")
				);
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("admin")
				.password(passwordEncoder().encode("admin123"))
				.roles("ADMIN")
				.build());
		return manager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}