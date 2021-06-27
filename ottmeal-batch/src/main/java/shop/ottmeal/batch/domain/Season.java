package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.common.domain.BaseSeason;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Season extends BaseSeason {

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public Season(LocalDateTime airDate, Integer episodeCount, Long id, String name, String overview, String posterPath, Integer seasonNumber, Tv tv) {
        super(airDate, episodeCount, id, name, overview, posterPath, seasonNumber);
        this.tv = tv;
    }
}
