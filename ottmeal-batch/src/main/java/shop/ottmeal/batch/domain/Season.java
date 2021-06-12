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
