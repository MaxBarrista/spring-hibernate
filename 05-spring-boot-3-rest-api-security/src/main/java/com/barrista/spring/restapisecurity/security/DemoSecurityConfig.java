package com.barrista.spring.restapisecurity.security;

import com.barrista.spring.restapisecurity.security.roles.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {
  @Bean
  public InMemoryUserDetailsManager userDetailsManager() {
    UserDetails max =
        User.builder()
            .username("max")
            .password("{bcrypt}$2a$10$a6tx7JyKoqe8bbd68YCPM.NsbPR8JE8KQGyEqqecDkfNbapWhZL8m")
            .roles(Roles.BARRISTA, Roles.CEO)
            .build();

    UserDetails luffy =
        User.builder()
            .username("luffy")
            .password("{bcrypt}$2a$10$Y7l/A/5UemcK0bMUOv0IiuZUqGudMHhgGfbZIx1opOD4nJxzG38rS")
            .roles(
                Roles.CAPTAIN_OF_THE_STRAW_HAT_PIRATES,
                Roles.MEMBER_OF_THE_STRAW_HAT_PIRATES,
                Roles.FIFTH_EMPEROR)
            .build();

    UserDetails zoro =
        User.builder()
            .username("zoro")
            .password("{bcrypt}$2a$10$jgQEg6tGUBS7oY8mcxZiduo7KR9tbu3WIqSVJv0fAWHqdkmY/loca")
            .roles(
                Roles.PIRATE_HUNTER_ZORO,
                Roles.MEMBER_OF_THE_STRAW_HAT_PIRATES,
                Roles.THREE_SWORD_STYLE_MASTER)
            .build();

    return new InMemoryUserDetailsManager(max, luffy, zoro);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        configurer ->
            configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole(Roles.BARRISTA, Roles.MEMBER_OF_THE_STRAW_HAT_PIRATES)
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole(Roles.BARRISTA, Roles.MEMBER_OF_THE_STRAW_HAT_PIRATES)
                .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole(Roles.BARRISTA, Roles.CAPTAIN_OF_THE_STRAW_HAT_PIRATES)
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole(Roles.BARRISTA, Roles.CAPTAIN_OF_THE_STRAW_HAT_PIRATES)
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasAnyRole(Roles.BARRISTA)
    );

    http.httpBasic(Customizer.withDefaults());
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }
}
