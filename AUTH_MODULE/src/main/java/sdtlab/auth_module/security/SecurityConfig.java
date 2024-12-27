package sdtlab.auth_module.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.server.DefaultServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Authorize requests
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/login", "/oauth2/**").permitAll()
                                .anyRequest().authenticated()
                )
                // Configure OAuth2 login
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .authorizationEndpoint(authorizationEndpoint ->
                                        authorizationEndpoint
                                                .authorizationRequestResolver(pkceResolver(null))
                                )
                                .loginPage("/login")
                                .defaultSuccessUrl("/home", true)
                );
        return http.build();
    }

    @Bean
    public OAuth2AuthorizationRequestResolver pkceResolver(ClientRegistrationRepository repo) {
        DefaultOAuth2AuthorizationRequestResolver resolver =
                new DefaultOAuth2AuthorizationRequestResolver(
                        repo,
                        OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI
                );
        resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
        return resolver;
    }

}
