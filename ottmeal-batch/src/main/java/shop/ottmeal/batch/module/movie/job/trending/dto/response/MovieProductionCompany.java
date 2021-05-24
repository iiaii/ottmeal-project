package shop.ottmeal.batch.module.movie.job.trending.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieProductionCompany {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("logo_path")
    private String logo_path;

    @JsonProperty("name")
    private String name;

    @JsonProperty("origin_country")
    private String origin_country;
}
