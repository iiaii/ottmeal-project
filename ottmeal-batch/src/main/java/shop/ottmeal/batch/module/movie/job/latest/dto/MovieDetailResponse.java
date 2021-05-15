package shop.ottmeal.batch.module.movie.job.latest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

//{
//        "adult": false,
//        "backdrop_path": "/z6fmvhQXS5hbXSizx4DGajjBmGD.jpg",
//        "belongs_to_collection": null,
//        "budget": 130000000,
//        "genres": [
//        {
//          "id": 878,
//          "name": "Science Fiction"
//        },
//        {
//          "id": 28,
//          "name": "Action"
//        },
//        {
//          "id": 53,
//          "name": "Thriller"
//        }
//        ],
//        "homepage": "",
//        "id": 929,
//        "imdb_id": "tt0120685",
//        "original_language": "en",
//        "original_title": "Godzilla",
//        "overview": "When a freighter is viciously attacked in the Pacific Ocean, a team of experts -- including biologist Niko Tatopoulos and scientists Elsie Chapman and Mendel Craven -- concludes that an oversized reptile is the culprit. Before long, the giant lizard is loose in Manhattan, destroying everything within its reach. The team chases the monster to Madison Square Garden, where a brutal battle ensues.",
//        "popularity": 36.645,
//        "poster_path": "/1wki1OaDA35RarysOPet25a8hVQ.jpg",
//        "production_companies": [
//        {
//          "id": 882,
//          "logo_path": "/fRSWWjquvzcHjACbtF53utZFIll.png",
//          "name": "Toho Company, Ltd.",
//          "origin_country": "JP"
//        },
//        {
//          "id": 559,
//          "logo_path": "/eC0bWHVjnjUducyA6YFoEFqnPMC.png",
//          "name": "TriStar Pictures",
//          "origin_country": "US"
//        },
//        {
//          "id": 620,
//          "logo_path": null,
//          "name": "Centropolis Film Productions",
//          "origin_country": ""
//        },
//        {
//          "id": 2833,
//          "logo_path": null,
//          "name": "Independent Pictures (II)",
//          "origin_country": ""
//        },
//        {
//          "id": 11343,
//          "logo_path": null,
//          "name": "Fried Films",
//          "origin_country": ""
//        }
//        ],
//        "production_countries": [
//        {
//          "iso_3166_1": "US",
//          "name": "United States of America"
//        }
//        ],
//        "release_date": "1998-05-20",
//        "revenue": 379014294,
//        "runtime": 139,
//        "spoken_languages": [
//        {
//          "english_name": "English",
//          "iso_639_1": "en",
//          "name": "English"
//        },
//        {
//          "english_name": "French",
//          "iso_639_1": "fr",
//          "name": "Français"
//        },
//        {
//          "english_name": "Japanese",
//          "iso_639_1": "ja",
//          "name": "日本語"
//        },
//        {
//          "english_name": "Russian",
//          "iso_639_1": "ru",
//          "name": "Pусский"
//        },
//        {
//          "english_name": "Spanish",
//          "iso_639_1": "es",
//          "name": "Español"
//        }
//        ],
//        "status": "Released",
//        "tagline": "Size does matter.",
//        "title": "Godzilla",
//        "video": false,
//        "vote_average": 5.6,
//        "vote_count": 2825
//}

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
