package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.common.domain.BaseSpokenLanguage;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class SpokenLanguage extends BaseSpokenLanguage {

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx")
    private Movie movie;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public SpokenLanguage(String englishName, String iso_639_1, String name, Movie movie, Tv tv) {
        super(englishName, iso_639_1, name);
        this.movie = movie;
        this.tv = tv;
    }
}
