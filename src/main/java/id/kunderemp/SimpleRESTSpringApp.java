package id.kunderemp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableAutoConfiguration
@SpringBootApplication
public class SimpleRESTSpringApp {
	
	static Logger log = LogManager.getLogger(SimpleRESTSpringApp.class);

    public static void main(String[] args) throws Exception {
    	log.debug("Started SimpleRESTSpringApp");
        SpringApplication.run(SimpleRESTSpringApp.class, args);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
            }
        };
    }

    
}
