//package shop.ottmeal.api.domain;
//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import shop.ottmeal.common.domain.BaseSeason;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@NoArgsConstructor
//@Entity
//@Table(name = "season")
//@Slf4j
//public class Season extends BaseSeason {
//
//    @Builder
//    public Season(Long idx, String title, String order, String director, boolean adult, Series series, List<Episode> episodes, List<Rating> ratings, List<Review> reviews) {
//        super(idx, title, order, director, adult);
//        this.series = series;
//        this.episodes = episodes;
//        this.ratings = ratings;
//        this.reviews = reviews;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Series series;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "season")
//    private List<Episode> episodes;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "season")
//    private List<Rating> ratings;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "season")
//    private List<Review> reviews;
//}
