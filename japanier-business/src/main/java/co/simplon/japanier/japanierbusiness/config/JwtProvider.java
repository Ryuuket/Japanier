package co.simplon.japanier.japanierbusiness.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

public final class JwtProvider {

    private final String issuer;

    private final long expiration;

    private final ZoneId zoneId;

    private final Algorithm algorithm;

    JwtProvider(String issuer, long expiration, String zoneId, Algorithm algorithm) {
	this.issuer = issuer;
	this.expiration = expiration;
	this.zoneId = ZoneId.of(zoneId);
	this.algorithm = algorithm;
    }

    String create(String subject, List<String> roles) {
	LocalDateTime now = LocalDateTime.now();
	Instant issuedAt = now.atZone(zoneId).toInstant();
	Builder builder = JWT.create().withIssuer(issuer).withIssuedAt(issuedAt);
	if (expiration > -1) {
	    LocalDateTime expires = now.plusSeconds(expiration);
	    Instant expiresAt = expires.atZone(zoneId).toInstant();
	    builder.withExpiresAt(expiresAt);
	}
	builder.withSubject(subject).withClaim("roles", roles);
	return builder.sign(algorithm);
    }

}