package shop.ottmeal.batch.module.trending.job.movie.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.ProductionCompany;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieProductionCompanyResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("logo_path")
    private String logo_path;

    @JsonProperty("name")
    private String name;

    @JsonProperty("origin_country")
    private String origin_country;

    public ProductionCompany toEntity() {
        return ProductionCompany.builder()
                .id(this.id)
                .logoPath(this.logo_path)
                .name(this.name)
                .originCountry(this.origin_country)
                .build();
    }
}
