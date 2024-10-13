package itsci.mju.coopeducation_management_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
		
	private final AuthenticationProvider authenticationProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(auth -> auth
					.requestMatchers("/**").permitAll()
					.anyRequest().authenticated()
				)
				.csrf().disable()
				.authenticationProvider(authenticationProvider)
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/authenticate")
						.defaultSuccessUrl("/home", true)
						.permitAll()
				)
				.logout(config -> config
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/home")
						.permitAll()
				)
				.build();
	}
	
	@Bean
	public GrantedAuthorityDefaults grantedAuthorityDefaults() {
	    return new GrantedAuthorityDefaults("");
	}
//	
//	@Bean
//    public UserDetailsService userDetailsService() {
//        return new AuthenticationService();  // Use your custom UserDetailsService
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();  // Use BCrypt for encoding passwords
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
	
}
