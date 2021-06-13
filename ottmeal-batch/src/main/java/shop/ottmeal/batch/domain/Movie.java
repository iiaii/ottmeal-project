package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id @GeneratedValue
    private Long idx;

    private Boolean adult;

    private String backdropPath;

    private Integer budget;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Genre> genres;

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
    private List<ProductionCompany> productionCompanies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<ProductionCountry> productionCountries;

    private LocalDateTime releaseDate;

    private Integer revenue;

    private Integer runtime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<SpokenLanguage> spokenLanguages;

    private String status;

    private String tagline;

    private String title;

    private Boolean video;

    private Double voteAverage;

    private Integer voteCount;

    @Builder
    public Movie(Boolean adult, String backdropPath, Integer budget, List<Genre> genres, String homepage, Long id, String imdbId, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries, LocalDateTime releaseDate, Integer revenue, Integer runtime, List<SpokenLanguage> spokenLanguages, String status, String tagline, String title, Boolean video, Double voteAverage, Integer voteCount) {
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
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }
}
