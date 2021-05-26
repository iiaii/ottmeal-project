package shop.ottmeal.batch.module.movie.job.trending.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.MovieProductionCountry;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieProductionCountryResponse {

    @JsonProperty("iso_3166_1")
    private String iso_3166_1;

    @JsonProperty("name")
    private String name;

    public MovieProductionCountry toEntity() {
        return MovieProductionCountry.builder()
                .iso_3166_1(this.iso_3166_1)
                .name(this.name)
                .build();
    }
}
