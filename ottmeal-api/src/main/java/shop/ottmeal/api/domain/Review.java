package shop.ottmeal.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.ottmeal.common.domain.BaseReview;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "review")
@Slf4j
public class Review extends BaseReview {

    @Builder
    public Review(Long idx, String title, String comment, Movie movie, Season season, Episode episode, User user) {
        super(idx, title, comment);
        this.movie = movie;
        this.season = season;
        this.episode = episode;
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    private Episode episode;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
