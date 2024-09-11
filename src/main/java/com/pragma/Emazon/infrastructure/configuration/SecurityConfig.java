package com.pragma.Emazon.infrastructure.configuration;

import com.pragma.Emazon.infrastructure.Utils.JwtUtils;
import com.pragma.Emazon.infrastructure.Utils.security.UserDetailServiceImpl;
import com.pragma.Emazon.infrastructure.configuration.filter.JwtTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtUtils jwtUtils;

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
        authoritiesConverter.setAuthorityPrefix("ROLE_");
        authoritiesConverter.setAuthoritiesClaimName("authorities");
        converter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
        return converter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationProvider authenticationProvider) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(http -> {
                    // EndPoints publicos
                    http.requestMatchers("/api/**").authenticated()
                            .requestMatchers("/swagger-ui/**").permitAll()
                            .requestMatchers("/auth/**").permitAll()
                            .requestMatchers("/v3/api-docs/**").permitAll()
                            .requestMatchers("/swagger-ui.html").permitAll()
                            .anyRequest().authenticated();
                })
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .build();
    }
    // public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    //     httpSecurity.authorizeHttpRequests(req ->
    //                     req
    //                             .requestMatchers("/api/**")
    //                             .hasAnyAuthority("ROLE_aux_bodega")
    //                             .requestMatchers("/swagger-ui/**").permitAll()
    //                             .requestMatchers("/auth/**").permitAll()
    //                             .requestMatchers("/v3/api-docs/**").permitAll()
    //                             .requestMatchers("/swagger-ui.html").permitAll()
    //                             .anyRequest().authenticated()
    //             )
    //             .oauth2ResourceServer(oauth2 -> oauth2
    //                     .jwt(jwt -> jwt
    //                             .jwtAuthenticationConverter(jwtAuthenticationConverter())
    //                     )
    //             )
    //             .csrf(csrf -> csrf.disable());

    //     //httpSecurity.addFilterBefore(JwtTokenValidator, org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationFilter.class);

    //     return httpSecurity.build();
    // }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        // Configura el JwtDecoder con la URI del JWKS endpoint del proveedor
        return NimbusJwtDecoder.withJwkSetUri("https://dev-34mzyluwbwzfnauy.us.auth0.com/.well-known/jwks.json").build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

}