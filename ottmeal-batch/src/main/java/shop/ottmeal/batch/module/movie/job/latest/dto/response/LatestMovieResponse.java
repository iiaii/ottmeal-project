package shop.ottmeal.batch.module.movie.job.latest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class LatestMovieResponse extends BaseResponse {

    private Long page;
    private List<LatestMovieResult> results;
    private Long total_pages;
    private Long total_results;
}
