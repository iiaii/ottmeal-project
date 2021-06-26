package shop.ottmeal.batch.module.trending.job.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.common.TimeUtils;
import shop.ottmeal.batch.domain.EpisodeToAir;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeToAirResponse {

    private String air_date;
    private int episode_number;
    private Long id;
    private String name;
    private String overview;
    private String production_code;
    private int season_number;
    private String still_path;
    private Double vote_average;
    private int vote_count;

    public EpisodeToAir toEntity() {
        return EpisodeToAir.builder()
                .airDate(TimeUtils.convertFromYyyyMmDd(this.air_date))
                .episodeNumber(this.episode_number)
                .id(this.id)
                .name(this.name)
                .overview(this.overview)
                .productionCode(this.production_code)
                .seasonNumber(this.season_number)
                .stillPath(this.still_path)
                .voteAverage(this.vote_average)
                .voteCount(this.vote_count)
                .build();
    }
}
