package co.simplon.japanier.japanierbusiness.config;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

public final class SecurityHelper {

    private final JwtProvider jwt;

    private final PasswordEncoder encoder;

    SecurityHelper(JwtProvider jwt, PasswordEncoder encoder) {
	this.jwt = jwt;
	this.encoder = encoder;
    }

    public String createToken(String subject, List<String> roles) {
	return jwt.create(subject, roles);
    }

    public String encode(String rawPassword) {
	return encoder.encode(rawPassword);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
	return encoder.matches(rawPassword, encodedPassword);
    }

}