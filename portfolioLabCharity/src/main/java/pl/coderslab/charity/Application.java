package pl.coderslab.charity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.coderslab.charity.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.coderslab.charity")
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run((Application.class), args);
    }
}
