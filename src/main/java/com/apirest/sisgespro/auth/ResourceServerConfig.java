package com.apirest.sisgespro.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET ,"/datos/estadoproyecto").permitAll()
		.antMatchers(HttpMethod.GET ,"/datos/rol").permitAll()
		.antMatchers(HttpMethod.GET ,"/datos/sector").permitAll()
		.antMatchers(HttpMethod.GET ,"/datos/tipoapp").permitAll()
		.antMatchers(HttpMethod.GET ,"/datos/tipoproyecto").permitAll()
		.antMatchers(HttpMethod.GET ,"/proyecto/inicio").permitAll()
		.antMatchers(HttpMethod.GET ,"/proyecto/buscarproyecto/{id}").permitAll()
		.antMatchers(HttpMethod.POST ,"/proyecto/crear").permitAll()
		.antMatchers(HttpMethod.PUT ,"/proyecto/actualizar/{id}").permitAll()
		.antMatchers(HttpMethod.DELETE ,"/proyecto/eliminar/{id}").permitAll()
		.antMatchers(HttpMethod.GET ,"/aplicativo/inicio").permitAll()
		.antMatchers(HttpMethod.GET ,"/aplicativo/buscaraplicativo/{id}").permitAll()
		.antMatchers(HttpMethod.POST ,"/aplicativo/crear").permitAll()
		.antMatchers(HttpMethod.PUT ,"/aplicativo/actualizar/{id}").permitAll()
		.antMatchers(HttpMethod.DELETE ,"/aplicativo/eliminar/{id}").permitAll()
		.antMatchers(HttpMethod.POST ,"/datos/crearestadoproyecto").permitAll()
		.antMatchers(HttpMethod.POST ,"/datos/crearrol").permitAll()
		.antMatchers(HttpMethod.POST ,"/datos/crearsector").permitAll()
		.antMatchers(HttpMethod.POST ,"/datos/creartipoapp").permitAll()
		.antMatchers(HttpMethod.POST ,"/datos/creartipoproyecto").permitAll()
		.antMatchers(HttpMethod.DELETE ,"/datos/estadoproyecto/{id}").permitAll()
		.antMatchers(HttpMethod.DELETE ,"/datos/rol/{id}").permitAll()
		.antMatchers(HttpMethod.DELETE ,"/datos/sector/{id}").permitAll()
		.antMatchers(HttpMethod.DELETE ,"/datos/tipoapp/{id}").permitAll()
		.antMatchers(HttpMethod.DELETE ,"/datos/tipoproyecto/{id}").permitAll()
		.antMatchers(HttpMethod.GET ,"/usuario/inicio").permitAll()
		.antMatchers(HttpMethod.POST ,"/usuario/crear").permitAll()
		//.antMatchers(HttpMethod.GET,"/proyecto/buscarproyecto/{id}").hasAnyRole("USER","ADMIN","PROGRAMADOR")
		//.antMatchers(HttpMethod.GET,"/proyecto/buscarproyecto/{id}").permitAll()
		//.antMatchers(HttpMethod.POST,"/proyecto/crear").hasRole("ADMIN")
		//.antMatchers("/proyecto/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config  = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	
	
}
