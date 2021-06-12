package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class LastEpisodeToAir {

    @Id @GeneratedValue
    private Long idx;
    private LocalDateTime airDate;
    private int episodeNumber;
    private Long id;
    private String name;
    @Lob
    private String overview;
    private String productionCode;
    private int seasonNumber;
    private String stillPath;
    private Double voteAverage;
    private int voteCount;

    @Builder
    public LastEpisodeToAir(LocalDateTime airDate, int episodeNumber, Long id, String name, String overview, String productionCode, int seasonNumber, String stillPath, Double voteAverage, int voteCount) {
        this.airDate = airDate;
        this.episodeNumber = episodeNumber;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.productionCode = productionCode;
        this.seasonNumber = seasonNumber;
        this.stillPath = stillPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }
}
