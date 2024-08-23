package itsci.mju.coopeducation_management_project.config;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import itsci.mju.coopeducation_management_project.model.Staff;
import itsci.mju.coopeducation_management_project.repository.StaffRepository;
import itsci.mju.coopeducation_management_project.service.StaffService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Autowired
	 private StaffService staffService;
	 
//	 @Autowired
//	 private StaffRepository staffRepository;
	 
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	     }
	 
	 @Autowired
	 @Qualifier("customUserDetailsService")
	 private UserDetailsService userDetailsService; 
	 
	 
	 
	 @Lazy
	 public void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	    
	 
	 @Bean
	    public UserDetailsService userDetailsService() {
		 UserDetails user1 = org.springframework.security.core.userdetails.User.builder()
	                .username("user1")
	                .password(passwordEncoder().encode("user_password_1"))
	                .roles("USER")
	                .build();

	        UserDetails user2 = org.springframework.security.core.userdetails.User.builder()
	                .username("user2")
	                .password(passwordEncoder().encode("user_password_2"))
	                .roles("USER")
	                .build();

	        UserDetails admin1 = org.springframework.security.core.userdetails.User.builder()
	                .username("admin1")
	                .password(passwordEncoder().encode("admin_password_1"))
	                .roles("ADMIN")
	                .build();
	        return new InMemoryUserDetailsManager(user1, user2, admin1);
	    }
	 
//	 @Bean
//	 public UserDetailsService userDetailsService() {
//		 return username -> {
//			 Staff staff = staffService.findByUsername(username);
//	         if (staff == null) {
//	             throw new UsernameNotFoundException("User not found");
//	         }
//	         return org.springframework.security.core.userdetails.User
//	                .withUsername(staff.getUsername())
//	                .password(staff.getPassword())
//	                .roles(staff.getRole())
//	                .build();
//	      };
//	  }
	 
	    
//	    @Bean
//	    public UserDetailsService userDetailsService() {
//	        return new CustomUserDetailsService(); // Implement this as needed
//	    }
	    
	    
	    @Bean
	    public AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(userDetailsService());
	        provider.setPasswordEncoder(passwordEncoder());
	        return provider;
	    }
	    
	    
	    @Bean
	    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class)
	            .authenticationProvider(authenticationProvider())
	            .build();
	    }
	    
	 
	 	@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	       httpSecurity
//	    		   .formLogin(httpForm -> {
//	    			   httpForm
//	    			   .loginPage("/login").permitAll();
//	    		   })
//	        .authorizeHttpRequests(home ->{
//	        	home.requestMatchers("/home").permitAll();
//	        	home.anyRequest().authenticated();
//	        })
//	        
//	        .build();
//	 	}
//}
//          .permitAll()
//	        
	        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
            	.requestMatchers("/home").hasRole("USER")
            	.requestMatchers("/request-form/add-request-form-page").hasRole("USER")
            	.requestMatchers("/request-form/add").hasRole("USER")
            	.requestMatchers("/referral-form/add-referral-form-page").hasRole("USER")            	
            	.requestMatchers("/request-form/list-request-page").hasRole("USER")
            	.requestMatchers("/referral-form/list-referral-page").hasRole("USER")
            	.requestMatchers("/view-status").hasRole("USER") 
            	.requestMatchers("/request-form/delete").hasRole("USER") 
            	
            	.requestMatchers("/majors/add-major-page").hasRole("ADMIN") 
            	.requestMatchers("/majors/add").hasRole("ADMIN")
            	.requestMatchers("/majors/list-major-page").hasRole("ADMIN")
            	.requestMatchers("/register").hasRole("ADMIN")
            	.requestMatchers("/faculty/list-coopeducation-page").hasRole("ADMIN")
            	.requestMatchers("/faculty/view-coop-requestform-detail-page").hasRole("ADMIN")
//            	.requestMatchers("/faculty/list-coopeducation-page").hasRole("ADMIN")

//            	.requestMatchers("/api/login").permitAll()
//            	.requestMatchers("/logout").permitAll()
            	.requestMatchers("/faculty/generate-pdf").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
        )
        .formLogin(httpformPage ->
            httpformPage
//                .loginPage("/login").permitAll()
            		.successHandler((request, response, authentication) -> {
            			String role = authentication.getAuthorities().stream()
            					.map(grantedAuthority -> grantedAuthority.getAuthority())
            					.findFirst().orElse("USER");
                
            			if (role.equals("ROLE_ADMIN")) {
            				response.sendRedirect("/register-form");
            			} else {
            				response.sendRedirect("/home");
            			}
            })
            .permitAll()
        )
        .logout((logout) -> logout
                .logoutUrl("/logout") // URL สำหรับ Logout
                .logoutSuccessUrl("/login?logout") // Redirect หลัง Logout สำเร็จ
                .permitAll()
        )
	       .csrf(AbstractHttpConfigurer::disable);
	        return httpSecurity.build();
	    }
	 	
	 	 
	 
//	 @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeRequests(authorizeRequests ->
//	                authorizeRequests
//	                    .antMatchers("/admin/**").hasRole("ADMIN")
//	                    .antMatchers("/user/**").hasRole("USER")
//	                    .anyRequest().authenticated()
//	            )
//	            .formLogin(withDefaults());
//
//	        return http.build();
//	    }
	 
//	 @Autowired
//	 private JwtAuthenticationFilter jwtAuthenticationFilter;
//	 
//	 @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//	        return httpSecurity
//	                .csrf(AbstractHttpConfigurer::disable)
//	                .authorizeHttpRequests(registry -> {
//	                    registry.requestMatchers("/home", "/register/**", "/authenticate").permitAll();
//	                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
//	                    registry.requestMatchers("/user/**").hasRole("USER");
//	                    registry.anyRequest().authenticated();
//	                })
//	                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
//	                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//	                .build();
//	    }
//	 
//	 @Autowired
//	 private StaffRepository staffRepository;
	 
	 
	
	 
	 


//	 
//	 	@Bean
//		 public PasswordEncoder passwordEncoder() {
//		     return new BCryptPasswordEncoder();
//		 }
//	 	
//	 	@Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeHttpRequests((authz) -> authz
//	            	.requestMatchers("/home").permitAll()
//	                .requestMatchers("/api/admins/**").hasRole("ADMIN")
//	                .requestMatchers("/api/users/**").hasAnyRole("USER", "ADMIN")
//	                .requestMatchers("/anonymous/**").anonymous()
//	                .requestMatchers("/login").permitAll()
//	                .anyRequest().authenticated()
//	            )
//	            .formLogin((form) -> form
////	                .loginPage("/login")
//	                .defaultSuccessUrl("/homepage", true)
//	                .failureUrl("/login?error=true")
//	                .permitAll()
//	            )
//	            .logout((logout) -> logout.permitAll());
//
//	        return http.build();
//	    }
//	 

	 
	 
	 
//	 @Bean
//	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    return http
//	        .csrf(csrf -> csrf.disable())
//	        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//         	.requestMatchers("/home").permitAll()
//         	.requestMatchers("/staffs/register").permitAll()
//         	.requestMatchers("/login").permitAll()
//             .requestMatchers("/admin/**").hasRole("ADMIN")
//             .requestMatchers("/user/**").hasRole("USER")
//             .anyRequest().authenticated()
//     )
//	        .oauth2ResourceServer(oauth2.jwt)
//	        .build();
////	        return http.build();
//	    }
	 
	 
}
