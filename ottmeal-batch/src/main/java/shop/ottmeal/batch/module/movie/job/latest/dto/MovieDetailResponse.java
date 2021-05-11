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
    private final boolean belongs_to_collection;

    @JsonProperty("genreIds")
    private final List<Long> genreIds;

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("originalLanguage")
    private final String originalLanguage;

    @JsonProperty("originalTitle")
    private final String originalTitle;

    @JsonProperty("overview")
    private final String overview;

    @JsonProperty("popularity")
    private final Double popularity;

    @JsonProperty("posterPath")
    private final String posterPath;

    @JsonProperty("releaseDate")
    private final String releaseDate;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("video")
    private final boolean video;

    @JsonProperty("voteAverage")
    private final Double voteAverage;

    @JsonProperty("voteCount")
    private final Long voteCount;

}
