package org.example.global.config;


import org.example.global.filter.CorsFilter;
import org.example.global.jwt.JwtAccessDeniedHandler;
import org.example.global.jwt.JwtAuthenticationEntryPoint;
import org.example.global.jwt.JwtSecurityConfig;
import org.example.global.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(200)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
	// private final JwtFilter jwtFilter;
	// private final JwtExceptionFilter jwtExceptionFilter;
	
	public SecurityConfig(
		TokenProvider tokenProvider,
		CorsFilter corsFilter,
		JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
		JwtAccessDeniedHandler jwtAccessDeniedHandler
		// JwtFilter jwtFilter
		// JwtExceptionFilter jwtExceptionFilter
	
	){
        this.tokenProvider = tokenProvider;
        this.corsFilter = corsFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
		// this.jwtFilter = jwtFilter;
		// this.jwtExceptionFilter = jwtExceptionFilter;
	}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http			
		
			.cors().configurationSource(corsConfigurationSource())    // rest api????????? csrf ????????? ?????????????????? disable??????.
			.and().csrf().disable()
 			.httpBasic().disable();
			      

	 	http.sessionManagement()
		 	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // jwt token?????? ??????????????? stateless ????????? ??????.
 			// .and()

		http.authorizeRequests()	
			// .antMatchers("/board/create").hasRole("USER")  // ??????????????? ????????? ?????????. 
			// .antMatchers("/api/v1/board/edit").hasRole("USER")  // ??????????????? ????????? ?????????. 
			.antMatchers("/get").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/join").permitAll()
			.antMatchers("/hello").permitAll();
			// .antMatchers("/api/v1/board/edit").permitAll();
		
		http
			.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
			// .addFilterBefore(usernamepass, JwtFilter.class)
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.accessDeniedHandler(jwtAccessDeniedHandler);
			// .expressionHanling
			// .antMatchers("/api/").permitAll();
			// .antMatchers("/").permitAll()
			// .anyRequest().authenticated();     // ????????? ?????? ?????? ??????  ( ?????? ?????? )

		http.apply(new JwtSecurityConfig(tokenProvider));

		// http.addFilter(jwtau)

	}
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
	}
	


}
