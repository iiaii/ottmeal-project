package shop.ottmeal.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.ottmeal.common.domain.BaseEpisode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "episode")
@Slf4j
public class Episode extends BaseEpisode {

    @Builder
    public Episode(Long idx, String title, String order, String director, boolean adult, Season season, List<Rating> ratings, List<Review> reviews) {
        super(idx, title, order, director, adult);
        this.season = season;
        this.ratings = ratings;
        this.reviews = reviews;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Season season;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "episode")
    private List<Rating> ratings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "episode")
    private List<Review> reviews;
}
