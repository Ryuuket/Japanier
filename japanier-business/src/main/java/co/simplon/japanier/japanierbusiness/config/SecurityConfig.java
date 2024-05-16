package co.simplon.japanier.japanierbusiness.config;

import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtIssuerValidator;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class SecurityConfig {

    @Value("${japanier.security.jwt.issuer}")
    private String issuer;

    @Value("${japanier.security.jwt.expiration}")
    private long expiration;

    @Value("${japanier.security.jwt.zoneId}")
    private String zoneId;

    @Value("${japanier.security.jwt.secret}")
    private String secret;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable())
		.logout(logout -> logout.disable())
		.sessionManagement(management -> management
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(req -> req
			.requestMatchers(HttpMethod.GET, "/lessons", "/exercises").permitAll())
		.authorizeHttpRequests(req -> req
			.requestMatchers(HttpMethod.POST, "/users/register", "/login").anonymous())
		// Autres routes
		.authorizeHttpRequests(reqs -> reqs.anyRequest().fullyAuthenticated())
		.oauth2ResourceServer(srv -> srv.jwt(Customizer.withDefaults()));
	return http.build();
    }

    private OAuth2TokenValidator<Jwt> tokenValidator() {
	List<OAuth2TokenValidator<Jwt>> validators = List.of(
		new JwtTimestampValidator(), new JwtIssuerValidator(issuer));
	return new DelegatingOAuth2TokenValidator<>(validators);
    }

    @Bean
    JwtDecoder jwtDecoder() {
	SecretKey secretKey = new SecretKeySpec(secret.getBytes(),
		"HMACSHA256");
	NimbusJwtDecoder decoder = NimbusJwtDecoder.withSecretKey(secretKey)
		.macAlgorithm(MacAlgorithm.HS256).build();
	decoder.setJwtValidator(tokenValidator());
	return decoder;
    }

    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
	JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
	authoritiesConverter.setAuthoritiesClaimName("roles");
	authoritiesConverter.setAuthorityPrefix("");
	JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
	authenticationConverter
		.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
	return authenticationConverter;
    }

    @Bean
    SecurityHelper securityHelper() {
	Algorithm algorithm = Algorithm.HMAC256(secret);
	JwtProvider provider = new JwtProvider(issuer, expiration, zoneId,
		algorithm);
	return new SecurityHelper(provider, new BCryptPasswordEncoder(12));
    }

}