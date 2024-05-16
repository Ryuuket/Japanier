package co.simplon.japanier.japanierbusiness.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Value("${japanier.cors.allowedOrigins}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**").allowedOrigins(allowedOrigins).allowedMethods("POST", "GET", "PUT", "PATCH",
		"DELETE");
    }

}
