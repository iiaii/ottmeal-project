package shop.ottmeal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "shop.ottmeal")
@EnableJpaAuditing
public class OttmealApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(OttmealApiApplication.class, args);
    }
}