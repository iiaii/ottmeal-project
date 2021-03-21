package shop.ottmeal.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.ottmeal.common.domain.BaseMovie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
@Slf4j
public class Movie extends BaseMovie {

    @Builder
    public Movie(Long idx, String title, String director, boolean adult, Platform platform, List<Rating> ratings, List<Review> reviews) {
        super(idx, title, director, adult);
        this.platform = platform;
        this.ratings = ratings;
        this.reviews = reviews;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Platform platform;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Rating> ratings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Review> reviews;
}
