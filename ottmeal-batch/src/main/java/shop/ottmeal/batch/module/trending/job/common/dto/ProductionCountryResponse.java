package shop.ottmeal.batch.module.trending.job.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.ProductionCountry;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductionCountryResponse {

    @JsonProperty("iso_3166_1")
    private String iso_3166_1;

    @JsonProperty("name")
    private String name;

    public ProductionCountry toEntity() {
        return ProductionCountry.builder()
                .iso_3166_1(this.iso_3166_1)
                .name(this.name)
                .build();
    }
}
