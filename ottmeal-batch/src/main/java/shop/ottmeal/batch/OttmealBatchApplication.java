package shop.ottmeal.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "shop.ottmeal")
@EnableBatchProcessing
@EnableJpaAuditing
public class OttmealBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(OttmealBatchApplication.class, args);
    }
}
