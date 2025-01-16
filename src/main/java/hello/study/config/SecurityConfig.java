package hello.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import hello.study.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	private final CustomUserDetailsService customUserDetailsService;

	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/", "/api/word/**", "/word/*", "/images/**").permitAll()
				            .requestMatchers("/admin").hasRole("ADMIN")
				            .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
				.anyRequest().authenticated()
				)
		        .formLogin(form -> form
		            .loginPage("/word/login") // 사용자 정의 로그인 페이지
		            .loginProcessingUrl("/word/login") // 로그인 폼의 action URL
		            .defaultSuccessUrl("/word/home", true) // 로그인 성공 후 이동할 URL
		            .failureUrl("/word/login?error=true") // 로그인 실패 시 이동할 URL
		            .permitAll()
		        )
		        .logout(logout -> logout
		            .logoutUrl("/word/logout")
		            .logoutSuccessUrl("/word/login?logout=true")
		            .permitAll()
		        );

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = 
				http.getSharedObject(AuthenticationManagerBuilder.class);

		authenticationManagerBuilder
		.userDetailsService((UserDetailsService) customUserDetailsService)  // CustomUserDetailsService를 UserDetailsService로 형변환
		.passwordEncoder(passwordEncoder);  // PasswordEncoder 설정

		return authenticationManagerBuilder.build();  // AuthenticationManager 빌드
	}
}