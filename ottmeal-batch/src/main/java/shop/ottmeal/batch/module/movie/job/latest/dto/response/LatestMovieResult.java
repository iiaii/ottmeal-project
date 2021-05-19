package shop.ottmeal.batch.module.movie.job.latest.dto.response;

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
public class LatestMovieResult {

//    {
//        "adult": false,
//        "backdrop_path": "/rspbS1E9wJtslrb8amfJgtMBUVh.jpg",
//        "genre_ids": [ 28, 27 ],
//        "id": 924,
//        "original_language": "en",
//        "original_title": "Dawn of the Dead",
//        "overview": "A group of survivors take refuge in a shopping mall after the world is taken over by aggressive, flesh-eating zombies.",
//        "popularity": 34.369,
//        "poster_path": "/iBLQATsIkv005fvIhhbM4MvqhYp.jpg",
//        "release_date": "2004-03-19",
//        "title": "Dawn of the Dead",
//        "video": false,
//        "vote_average": 7,
//        "vote_count": 2731
//    }

    @JsonProperty("adult")
    private final boolean adult;

    @JsonProperty("genreIds")
    private final List<Long> genreIds;

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("original_language")
    private final String original_language;

    @JsonProperty("original_title")
    private final String original_title;

    @JsonProperty("overview")
    private final String overview;

    @JsonProperty("popularity")
    private final Double popularity;

    @JsonProperty("poster_path")
    private final String poster_path;

    @JsonProperty("release_date")
    private final String release_date;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("video")
    private final boolean video;

    @JsonProperty("vote_average")
    private final Double vote_average;

    @JsonProperty("vote_count")
    private final Long vote_count;
}
