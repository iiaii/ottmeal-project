package shop.ottmeal.batch.module.movie.job.latest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailResponse {

    @JsonProperty("adult")
    private final boolean adult;

    @JsonProperty("backdrop_path")
    private final String backdrop_path;

    @JsonProperty("belongs_to_collection")
    private final String belongs_to_collection;

    @JsonProperty("budget")
    private final Long budget;

    @JsonProperty("genres")
    private final List<MovieGenresDto> genres;

    @JsonProperty("homepage")
    private final String homepage;

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("imdb_id")
    private final String imdb_id;

    @JsonProperty("original_language")
    private final String original_language;

    @JsonProperty("original_title")
    private final String original_title;

    @JsonProperty("overview")
    private final String overview;

    @JsonProperty("popularity")
    private final Double popularity;

    @JsonProperty("poster_path")
    private final Double poster_path;

    @JsonProperty("production_companies")
    private final List<ProductionCompany> production_companies;

    @JsonProperty("production_countries")
    private final List<ProductionCountry> production_countries;

    @JsonProperty("release_date")
    private final String release_date;

    @JsonProperty("revenue")
    private final Long revenue;

    @JsonProperty("runtime")
    private final Long runtime;

    @JsonProperty("spoken_languages")
    private final List<SpokenLanguage> spoken_languages;

    @JsonProperty("status")
    private final String status;

    @JsonProperty("tagline")
    private final String tagline;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("video")
    private final boolean video;

    @JsonProperty("vote_average")
    private final Double vote_average;

    @JsonProperty("vote_count")
    private final Long vote_count;

}
