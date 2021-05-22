package shop.ottmeal.batch.module.movie.job.trending.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductionCompany {

    private final Long id;
    private final String logo_path;
    private final String name;
    private final String origin_country;
}
