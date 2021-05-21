package shop.ottmeal.batch.module.movie.job.latest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
    private boolean adult;

    @JsonProperty("genre_ids")
    private List<Long> genre_ids;

    @JsonProperty("id")
    private Long id;

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

    @JsonProperty("release_date")
    private String release_date;

    @JsonProperty("title")
    private String title;

    @JsonProperty("video")
    private boolean video;

    @JsonProperty("vote_average")
    private Double vote_average;

    @JsonProperty("vote_count")
    private Long vote_count;
}
