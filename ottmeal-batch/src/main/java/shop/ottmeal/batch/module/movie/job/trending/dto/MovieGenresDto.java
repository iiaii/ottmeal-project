package shop.ottmeal.batch.module.movie.job.trending.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieGenresDto {

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("name")
    private final String name;
}
