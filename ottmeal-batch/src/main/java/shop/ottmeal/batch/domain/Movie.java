package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
@Slf4j
public class Movie {

    @Id @GeneratedValue
    private Long idx;
    private boolean adult;
    private String backdropPath;
    private Object belongsToCollection;
    private int budget;
    private List<MovieGenre> genres;
    private String homepage;
    private Long id;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private String posterPath;
    private List<MovieProductionCompany> productionCompanies;
    private List<MovieProductionCountry> productionCountries;
    private String release_date;
    private int revenue;
    private Integer runtime;
    private List<MovieSpokenLanguage> spokenLanguages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private Double voteAverage;
    private int voteCount;

    @Builder
    public Movie(boolean adult, String backdropPath, Object belongsToCollection, int budget, List<MovieGenre> genres, String homepage, Long id, String imdbId, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, List<MovieProductionCompany> productionCompanies, List<MovieProductionCountry> productionCountries, String release_date, int revenue, Integer runtime, List<MovieSpokenLanguage> spokenLanguages, String status, String tagline, String title, boolean video, Double voteAverage, int voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongsToCollection = belongsToCollection;
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
    }

    public static Movie toEntity(MovieDetailResponse movieDetailResponse) {
        return Movie.builder()
                .adult(movieDetailResponse.isAdult())
                .backdropPath(movieDetailResponse.getBackdrop_path())
                .belongsToCollection(movieDetailResponse.getBelongs_to_collection())
                .budget(movieDetailResponse.getBudget())
                .genres(movieDetailResponse.getGenres())
                .homepage(movieDetailResponse.getHomepage())
                .id(movieDetailResponse.getId())
                .imdbId(movieDetailResponse.getImdb_id())
                .originalLanguage(movieDetailResponse.getOriginal_language())
                .originalTitle(movieDetailResponse.getOriginal_title())
                .overview(movieDetailResponse.getOverview())
                .popularity(movieDetailResponse.getPopularity())
                .posterPath(movieDetailResponse.getPoster_path())
                .productionCompanies(movieDetailResponse.getProduction_companies())
                .productionCountries(movieDetailResponse.getProduction_countries())
                .release_date(movieDetailResponse.getRelease_date())
                .revenue(movieDetailResponse.getRevenue())
                .runtime(movieDetailResponse.getRuntime())
                .spokenLanguages(movieDetailResponse.getSpoken_languages())
                .status(movieDetailResponse.getStatus())
                .tagline(movieDetailResponse.getTagline())
                .title(movieDetailResponse.getTitle())
                .video(movieDetailResponse.isVideo())
                .voteAverage(movieDetailResponse.getVote_average())
                .voteCount(movieDetailResponse.getVote_count())
                .build();
    }
}
