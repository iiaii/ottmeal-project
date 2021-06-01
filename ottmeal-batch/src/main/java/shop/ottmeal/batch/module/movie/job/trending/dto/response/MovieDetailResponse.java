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

    public static Movie toEntity(MovieDetailResponse movieDetailResponse) {
        List<MovieGenre> movieGenres = movieDetailResponse.getGenres().stream().map(MovieGenreResponse::toEntity).collect(Collectors.toList());
        List<MovieProductionCompany> movieProductionCompanies = movieDetailResponse.getProduction_companies().stream().map(MovieProductionCompanyResponse::toEntity).collect(Collectors.toList());
        List<MovieProductionCountry> movieProductionCountries = movieDetailResponse.getProduction_countries().stream().map(MovieProductionCountryResponse::toEntity).collect(Collectors.toList());
        List<MovieSpokenLanguage> movieSpokenLanguages = movieDetailResponse.getSpoken_languages().stream().map(MovieSpokenLanguageResponse::toEntity).collect(Collectors.toList());

        Movie movie = Movie.builder()
                .adult(movieDetailResponse.isAdult())
                .backdropPath(movieDetailResponse.getBackdrop_path())
                .budget(movieDetailResponse.getBudget())
                .genres(movieGenres)
                .homepage(movieDetailResponse.getHomepage())
                .id(movieDetailResponse.getId())
                .imdbId(movieDetailResponse.getImdb_id())
                .originalLanguage(movieDetailResponse.getOriginal_language())
                .originalTitle(movieDetailResponse.getOriginal_title())
                .overview(movieDetailResponse.getOverview())
                .popularity(movieDetailResponse.getPopularity())
                .posterPath(movieDetailResponse.getPoster_path())
                .productionCompanies(movieProductionCompanies)
                .productionCountries(movieProductionCountries)
                .release_date(movieDetailResponse.getRelease_date())
                .revenue(movieDetailResponse.getRevenue())
                .runtime(movieDetailResponse.getRuntime())
                .spokenLanguages(movieSpokenLanguages)
                .status(movieDetailResponse.getStatus())
                .tagline(movieDetailResponse.getTagline())
                .title(movieDetailResponse.getTitle())
                .video(movieDetailResponse.isVideo())
                .voteAverage(movieDetailResponse.getVote_average())
                .voteCount(movieDetailResponse.getVote_count())
                .build();

        movieGenres.stream()
                .forEach(genre -> genre.setMovie(movie));
        movieProductionCompanies.stream()
                .forEach(productionCompany -> productionCompany.setMovie(movie));
        movieProductionCountries.stream()
                .forEach(productionCountry -> productionCountry.setMovie(movie));
        movieSpokenLanguages.stream()
                .forEach(spokenLanguage -> spokenLanguage.setMovie(movie));

        return movie;
    }
}
