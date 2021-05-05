package shop.ottmeal.batch.module.movie.job.latest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestMovieResponse {

//    {
//        "adult": false,
//            "backdrop_path": "/rspbS1E9wJtslrb8amfJgtMBUVh.jpg",
//            "genre_ids": [
//        28,
//                27
//            ],
//        "id": 924,
//            "original_language": "en",
//            "original_title": "Dawn of the Dead",
//            "overview": "A group of survivors take refuge in a shopping mall after the world is taken over by aggressive, flesh-eating zombies.",
//            "popularity": 34.369,
//            "poster_path": "/iBLQATsIkv005fvIhhbM4MvqhYp.jpg",
//            "release_date": "2004-03-19",
//            "title": "Dawn of the Dead",
//            "video": false,
//            "vote_average": 7,
//            "vote_count": 2731
//    }

    @JsonProperty("adult")
    private final boolean adult;

    @JsonProperty("genreIds")
    private final String genreIds;

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
