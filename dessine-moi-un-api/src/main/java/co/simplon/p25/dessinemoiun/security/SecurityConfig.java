package co.simplon.p25.dessinemoiun.security;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${dessinemoiun.security.jwt.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.cors().and().csrf().disable().logout().disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		// ANONYMOUS authorizations
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/auth/create-orderer",
			"/auth/create-artist", "/auth/login")
		.permitAll().and().authorizeRequests()
		.antMatchers(HttpMethod.PATCH, "/auth/lost-password")
		.permitAll().and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/artmediums", "/artformats",
			"/projects/price", "/artists/cards", "/artists/profile")
		.permitAll()
		// ARTIST authorizations
		.and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/projects/artist")
		.hasRole("ARTIST").and().authorizeRequests()
		.antMatchers(HttpMethod.PATCH, "/projects/accept")
		.hasRole("ARTIST")
		// ORDERER authorizations
		.and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/projects/orderer",
			"/profiles/name")
		.hasRole("ORDERER").and().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/projects").hasRole("ORDERER")
		// ORDERER or ARTIST authorizations
		.and().authorizeRequests()
		.antMatchers(HttpMethod.PATCH, "/auth/reset-password",
			"/profiles/update-names")
		.hasAnyRole("ORDERER", "ARTIST").and().authorizeRequests()
		.antMatchers(HttpMethod.DELETE, "/projects/{id}")
		.hasAnyRole("ORDERER", "ARTIST")
		//
		.and().authorizeRequests().anyRequest().authenticated().and()
		.oauth2ResourceServer().jwt();

    }

    @Bean
    public JwtDecoder jwtDecoder() {
	SecretKey secretKey = new SecretKeySpec(secret.getBytes(),
		"HMACSHA256");
	return NimbusJwtDecoder.withSecretKey(secretKey)
		.macAlgorithm(MacAlgorithm.HS256).build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
	JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
	authoritiesConverter.setAuthoritiesClaimName("roles");
	authoritiesConverter.setAuthorityPrefix("");
	JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
	authenticationConverter
		.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
	return authenticationConverter;
    }

}
