package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.common.domain.BaseGenre;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Genre extends BaseGenre {

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx")
    private Movie movie;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public Genre(Long id, String name, Movie movie, Tv tv) {
        super(id, name);
        this.movie = movie;
        this.tv = tv;
    }
}
