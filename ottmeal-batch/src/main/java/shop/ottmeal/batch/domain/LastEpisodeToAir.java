package shop.ottmeal.batch.domain;

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
}
