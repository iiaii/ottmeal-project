package shop.ottmeal.batch.module.movie.job.trending.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.MovieGenre;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieGenreResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    public MovieGenre toEntity() {
        return MovieGenre.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}
