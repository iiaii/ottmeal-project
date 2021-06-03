package shop.ottmeal.batch.module.trending.job.movie.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.MovieSpokenLanguage;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSpokenLanguageResponse {

    @JsonProperty("iso_639_1")
    private String iso_639_1;

    @JsonProperty("name")
    private String name;

    public MovieSpokenLanguage toEntity() {
        return MovieSpokenLanguage.builder()
                .iso_639_1(this.iso_639_1)
                .name(this.name)
                .build();
    }
}
