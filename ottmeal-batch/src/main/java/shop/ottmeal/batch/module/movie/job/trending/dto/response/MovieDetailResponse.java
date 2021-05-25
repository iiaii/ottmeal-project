package shop.ottmeal.batch.module.movie.job.trending.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailResponse {

    @JsonProperty("adult")
    private boolean adult;

    @JsonProperty("backdrop_path")
    private String backdrop_path;

    @JsonProperty("belongs_to_collection")
    private Object belongs_to_collection;

    @JsonProperty("budget")
    private int budget;

    @JsonProperty("genres")
    private List<MovieGenre> genres;

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
    private List<MovieProductionCompany> production_companies;

    @JsonProperty("production_countries")
    private List<MovieProductionCountry> production_countries;

    @JsonProperty("release_date")
    private String release_date;

    @JsonProperty("revenue")
    private int revenue;

    @JsonProperty("runtime")
    private Integer runtime;

    @JsonProperty("spoken_languages")
    private List<MovieSpokenLanguage> spoken_languages;

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
}
