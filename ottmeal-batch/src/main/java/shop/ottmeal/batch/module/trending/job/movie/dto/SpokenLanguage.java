package shop.ottmeal.batch.module.trending.job.movie.dto;

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
public class SpokenLanguage {

    private final String english_name;
    private final String iso_639_1;
    private final String name;
}
