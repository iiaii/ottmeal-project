package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
@Slf4j
public class Movie {

    @Id @GeneratedValue
    @Column(name = "")
    private Long idx;

    private Long id;
    private String title;
    private String overview;
    private String posterImgUrl;

    @ElementCollection
    private Set<String> genres = new HashSet<>();

    private Double popularity;
    private Double voteAverage;
    private Long voteCount;

    private Language language;

    @Builder
    public Movie(Long idx, Long id, String title, String overview, String posterImgUrl, Set<String> genres, Double popularity, Double voteAverage, Long voteCount, Language language) {
        this.idx = idx;
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterImgUrl = posterImgUrl;
        this.genres = genres;
        this.popularity = popularity;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.language = language;
    }
}
