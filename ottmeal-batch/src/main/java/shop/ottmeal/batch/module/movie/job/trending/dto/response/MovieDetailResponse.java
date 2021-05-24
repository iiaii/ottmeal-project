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
    private List<MovieGenre> production_companies;

//    "adult": false,
//                "backdrop_path": "/z6fmvhQXS5hbXSizx4DGajjBmGD.jpg",
//                "belongs_to_collection": null,
//                "budget": 130000000,
//                "genres": [
//        {
//            "id": 878,
//                "name": "Science Fiction"
//        },
//        {
//            "id": 28,
//                "name": "Action"
//        },
//        {
//            "id": 53,
//                "name": "Thriller"
//        }
//    ],
//            "homepage": "",
//            "id": 929,
//            "imdb_id": "tt0120685",
//            "original_language": "en",
//            "original_title": "Godzilla",
//            "overview": "When a freighter is viciously attacked in the Pacific Ocean, a team of experts -- including biologist Niko Tatopoulos and scientists Elsie Chapman and Mendel Craven -- concludes that an oversized reptile is the culprit. Before long, the giant lizard is loose in Manhattan, destroying everything within its reach. The team chases the monster to Madison Square Garden, where a brutal battle ensues.",
//            "popularity": 32.716,
//            "poster_path": "/tqQ9Nt5C1Z5PRDPxYXQ4qwy5v5V.jpg",
//            "production_companies": [
//        {
//            "id": 882,
//                "logo_path": "/fRSWWjquvzcHjACbtF53utZFIll.png",
//                "name": "Toho Co.",
//                "origin_country": "JP"
//        },
//        {
//            "id": 559,
//                "logo_path": "/eC0bWHVjnjUducyA6YFoEFqnPMC.png",
//                "name": "TriStar Pictures",
//                "origin_country": "US"
//        },
//        {
//            "id": 620,
//                "logo_path": null,
//                "name": "Centropolis Film Productions",
//                "origin_country": ""
//        },
//        {
//            "id": 2833,
//                "logo_path": null,
//                "name": "Independent Pictures (II)",
//                "origin_country": ""
//        },
//        {
//            "id": 11343,
//                "logo_path": null,
//                "name": "Fried Films",
//                "origin_country": ""
//        }
//    ],
//            "production_countries": [
//        {
//            "iso_3166_1": "US",
//                "name": "United States of America"
//        }
//    ],
//            "release_date": "1998-05-20",
//            "revenue": 379014294,
//            "runtime": 139,
//            "spoken_languages": [
//        {
//            "english_name": "English",
//                "iso_639_1": "en",
//                "name": "English"
//        },
//        {
//            "english_name": "French",
//                "iso_639_1": "fr",
//                "name": "Français"
//        },
//        {
//            "english_name": "Japanese",
//                "iso_639_1": "ja",
//                "name": "日本語"
//        },
//        {
//            "english_name": "Russian",
//                "iso_639_1": "ru",
//                "name": "Pусский"
//        },
//        {
//            "english_name": "Spanish",
//                "iso_639_1": "es",
//                "name": "Español"
//        }
//    ],
//            "status": "Released",
//            "tagline": "Size does matter.",
//            "title": "Godzilla",
//            "video": false,
//            "vote_average": 5.6,
//            "vote_count": 2838



}
