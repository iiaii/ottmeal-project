package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id @GeneratedValue
    @Column(name = "movie_idx")
    private Long idx;

    private boolean adult;

    private String backdropPath;

    private int budget;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<MovieGenre> genres;

    private String homepage;

    private Long id;

    private String imdbId;

    private String originalLanguage;

    private String originalTitle;

    @Lob
    private String overview;

    private Double popularity;

    private String posterPath;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<MovieProductionCompany> productionCompanies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<MovieProductionCountry> productionCountries;

    private String release_date;

    private int revenue;

    private Integer runtime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<MovieSpokenLanguage> spokenLanguages;

    private String status;

    private String tagline;

    private String title;

    private boolean video;

    private Double voteAverage;

    private int voteCount;

    @Builder
    public Movie(boolean adult, String backdropPath, int budget, List<MovieGenre> genres, String homepage, Long id, String imdbId, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, List<MovieProductionCompany> productionCompanies, List<MovieProductionCountry> productionCountries, String release_date, int revenue, Integer runtime, List<MovieSpokenLanguage> spokenLanguages, String status, String tagline, String title, boolean video, Double voteAverage, int voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;

//        if (!CollectionUtils.isEmpty(genres)) {
//            genres.stream()
//                    .forEach(genre -> genre.setMovie(this));
//        }
//        if (!CollectionUtils.isEmpty(productionCompanies)) {
//            productionCompanies.stream()
//                    .forEach(productionCompany -> productionCompany.setMovie(this));
//        }
//        if (!CollectionUtils.isEmpty(productionCountries)) {
//            productionCountries.stream()
//                    .forEach(productionCountry -> productionCountry.setMovie(this));
//        }
//        if (!CollectionUtils.isEmpty(spokenLanguages)) {
//            spokenLanguages.stream()
//                    .forEach(spokenLanguage -> spokenLanguage.setMovie(this));
//        }
    }
}
