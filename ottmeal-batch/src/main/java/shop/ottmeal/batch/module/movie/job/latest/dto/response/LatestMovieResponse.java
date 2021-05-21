package shop.ottmeal.batch.module.movie.job.latest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestMovieResponse {

    @JsonProperty("page")
    private final Integer page;

    @JsonProperty("results")
    private final List<LatestMovieResult> results;

    @JsonProperty("total_pages")
    private final Integer total_pages;

    @JsonProperty("total_results")
    private final Integer total_results;
}
