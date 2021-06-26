package shop.ottmeal.batch.module.trending.job.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import shop.ottmeal.batch.common.TimeUtils;
import shop.ottmeal.batch.domain.Season;
import shop.ottmeal.batch.domain.Tv;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonResponse {

    private String airDate;
    private Integer episodeCount;
    private Long id;
    private String name;
    private String overview;
    private String posterPath;
    private int seasonNumber;

    public Season toEntity() {
        return Season.builder()
                .airDate(TimeUtils.convertFromYyyyMmDd(this.airDate))
                .episodeCount(this.episodeCount)
                .id(this.id)
                .name(this.name)
                .overview(this.overview)
                .posterPath(this.posterPath)
                .seasonNumber(this.seasonNumber)
                .build();
    }
}
