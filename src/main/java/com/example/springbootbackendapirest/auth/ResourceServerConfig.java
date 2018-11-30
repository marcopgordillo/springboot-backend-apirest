package com.example.springbootbackendapirest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**").permitAll() // esto es público
            .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN") // en este caso no es necesario usar ROLE_USER ya que por detrás spring-security ya lo hace.
            .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
            .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
            .antMatchers("/api/clientes/**").hasRole("ADMIN") // las rutas se las realiza desde lo general hacia lo más genérico.
            .anyRequest().authenticated();
  }
}
