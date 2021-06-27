package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.common.domain.BaseEpisodeToAir;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class EpisodeToAir extends BaseEpisodeToAir {

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public EpisodeToAir(LocalDateTime airDate, Integer episodeNumber, Long id, String name, String overview, String productionCode, Integer seasonNumber, String stillPath, Double voteAverage, Integer voteCount, Tv tv) {
        super(airDate, episodeNumber, id, name, overview, productionCode, seasonNumber, stillPath, voteAverage, voteCount);
        this.tv = tv;
    }
}
