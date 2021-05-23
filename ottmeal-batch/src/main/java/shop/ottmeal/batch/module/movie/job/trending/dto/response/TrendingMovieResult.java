package shop.ottmeal.batch.module.movie.job.trending.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrendingMovieResult {

//    {
//            "id": 503736,
//            "original_language": "en",
//            "overview": "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
//            "poster_path": "/x3taBaWfRzw1NIKhEPpKPwKBAOC.jpg",
//            "vote_count": 387,
//            "video": false,
//            "adult": false,
//            "backdrop_path": "/c0izdYdnTe4uMRifHgvTA85wPz0.jpg",
//            "title": "Army of the Dead",
//            "genre_ids": [
//                28,
//                27,
//                53
//            ],
//            "vote_average": 6.7,
//            "release_date": "2021-05-14",
//            "original_title": "Army of the Dead",
//            "popularity": 439.314,
//            "media_type": "movie"
//        }

    @JsonProperty("id")
    private Long id;

    @JsonProperty("original_language")
    private String original_language;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("poster_path")
    private String poster_path;

    @JsonProperty("vote_count")
    private Long vote_count;

    @JsonProperty("video")
    private boolean video;

    @JsonProperty("adult")
    private boolean adult;

    @JsonProperty("backdrop_path")
    private String backdrop_path;

    @JsonProperty("title")
    private String title;

    @JsonProperty("genre_ids")
    private List<Long> genre_ids;

    @JsonProperty("vote_average")
    private Double vote_average;

    @JsonProperty("release_date")
    private String release_date;

    @JsonProperty("original_title")
    private String original_title;

    @JsonProperty("popularity")
    private Double popularity;

    @JsonProperty("media_type")
    private String media_type;
}
