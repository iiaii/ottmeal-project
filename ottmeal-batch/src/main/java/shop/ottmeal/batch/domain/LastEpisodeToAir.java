package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

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
