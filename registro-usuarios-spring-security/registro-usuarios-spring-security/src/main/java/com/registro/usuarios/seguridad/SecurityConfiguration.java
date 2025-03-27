package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.registro.usuarios.servicio.UsuarioServicio;

@Configuration
public class SecurityConfiguration {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@Autowired
	private CustomSuccesHandler successHandler; // Inyectamos el CustomSuccessHandler

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServicio);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}


	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}


	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/registro**", "/js/**", "/css/**", "/img/**").permitAll()
				.antMatchers("/admin/**").hasRole("admin")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/admin/**").hasRole("Admin")
				.antMatchers("/user/**").hasRole("user")
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/user/**").hasRole("User")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.successHandler(successHandler) // Agregamos el manejador de éxito
				.permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}
}
