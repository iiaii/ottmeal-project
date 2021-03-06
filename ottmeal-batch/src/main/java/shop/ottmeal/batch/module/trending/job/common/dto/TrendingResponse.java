package shop.ottmeal.batch.module.trending.job.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrendingResponse {

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("results")
    private List<TrendingResult> results;

    @JsonProperty("total_pages")
    private Integer total_pages;

    @JsonProperty("total_results")
    private Integer total_results;
}
