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
public class Season {

    @Id
    @GeneratedValue
    private Long idx;
    private LocalDateTime airDate;
    private Integer episodeCount;
    private Long id;
    private String name;
    @Lob
    private String overview;
    private String posterPath;
    private int seasonNumber;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public Season(LocalDateTime airDate, Integer episodeCount, Long id, String name, String overview, String posterPath, int seasonNumber) {
        this.airDate = airDate;
        this.episodeCount = episodeCount;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.posterPath = posterPath;
        this.seasonNumber = seasonNumber;
    }
}
