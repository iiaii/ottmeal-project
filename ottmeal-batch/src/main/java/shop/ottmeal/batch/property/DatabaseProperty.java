package shop.ottmeal.batch.property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Getter @Setter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "database")
@Validated
public class DatabaseProperty {
}
