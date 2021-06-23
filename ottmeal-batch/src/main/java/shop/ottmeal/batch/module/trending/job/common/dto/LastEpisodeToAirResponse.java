package shop.ottmeal.batch.module.trending.job.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.LastEpisodeToAir;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastEpisodeToAirResponse {

    private LocalDateTime airDate;
    private int episodeNumber;
    private Long id;
    private String name;
    private String overview;
    private String productionCode;
    private int seasonNumber;
    private String stillPath;
    private Double voteAverage;
    private int voteCount;

    public LastEpisodeToAir toEntity() {
        return LastEpisodeToAir.builder()
                .airDate(this.airDate)
                .episodeNumber(this.episodeNumber)
                .id(this.id)
                .name(this.name)
                .overview(this.overview)
                .productionCode(this.productionCode)
                .seasonNumber(this.seasonNumber)
                .stillPath(this.stillPath)
                .voteAverage(this.voteAverage)
                .voteCount(this.voteCount)
                .build();
    }
}
