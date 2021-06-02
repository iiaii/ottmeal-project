package shop.ottmeal.batch.module.movie.job.trending.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.domain.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailResponse {

    @JsonProperty("adult")
    private boolean adult;

    @JsonProperty("backdrop_path")
    private String backdrop_path;

//    @JsonProperty("belongs_to_collection")
//    private Object belongs_to_collection;

    @JsonProperty("budget")
    private int budget;

    @JsonProperty("genres")
    private List<MovieGenreResponse> genres;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("imdb_id")
    private String imdb_id;

    @JsonProperty("original_language")
    private String original_language;

    @JsonProperty("original_title")
    private String original_title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("popularity")
    private Double popularity;

    @JsonProperty("poster_path")
    private String poster_path;

    @JsonProperty("production_companies")
    private List<MovieProductionCompanyResponse> production_companies;

    @JsonProperty("production_countries")
    private List<MovieProductionCountryResponse> production_countries;

    @JsonProperty("release_date")
    private String release_date;

    @JsonProperty("revenue")
    private int revenue;

    @JsonProperty("runtime")
    private Integer runtime;

    @JsonProperty("spoken_languages")
    private List<MovieSpokenLanguageResponse> spoken_languages;

    @JsonProperty("status")
    private String status;

    @JsonProperty("tagline")
    private String tagline;

    @JsonProperty("title")
    private String title;

    @JsonProperty("video")
    private boolean video;

    @JsonProperty("vote_average")
    private Double vote_average;

    @JsonProperty("vote_count")
    private int vote_count;

    public static Movie toEntity(MovieDetailResponse movieDetail) {
        Movie movie = Movie.builder()
                .adult(movieDetail.isAdult())
                .backdropPath(movieDetail.getBackdrop_path())
                .budget(movieDetail.getBudget())
                .genres(movieDetail.getGenres().stream().map(MovieGenreResponse::toEntity).collect(Collectors.toList()))
                .homepage(movieDetail.getHomepage())
                .id(movieDetail.getId())
                .imdbId(movieDetail.getImdb_id())
                .originalLanguage(movieDetail.getOriginal_language())
                .originalTitle(movieDetail.getOriginal_title())
                .overview(movieDetail.getOverview())
                .popularity(movieDetail.getPopularity())
                .posterPath(movieDetail.getPoster_path())
                .productionCompanies(movieDetail.getProduction_companies().stream().map(MovieProductionCompanyResponse::toEntity).collect(Collectors.toList()))
                .productionCountries(movieDetail.getProduction_countries().stream().map(MovieProductionCountryResponse::toEntity).collect(Collectors.toList()))
                .release_date(movieDetail.getRelease_date())
                .revenue(movieDetail.getRevenue())
                .runtime(movieDetail.getRuntime())
                .spokenLanguages(movieDetail.getSpoken_languages().stream().map(MovieSpokenLanguageResponse::toEntity).collect(Collectors.toList()))
                .status(movieDetail.getStatus())
                .tagline(movieDetail.getTagline())
                .title(movieDetail.getTitle())
                .video(movieDetail.isVideo())
                .voteAverage(movieDetail.getVote_average())
                .voteCount(movieDetail.getVote_count())
                .build();

        movie.getGenres().stream().forEach(genre -> genre.setMovie(movie));
        movie.getProductionCompanies().stream().forEach(productionCompany -> productionCompany.setMovie(movie));
        movie.getProductionCountries().stream().forEach(productionCountry -> productionCountry.setMovie(movie));
        movie.getSpokenLanguages().stream().forEach(spokenLanguage -> spokenLanguage.setMovie(movie));

        return movie;
    }
}
