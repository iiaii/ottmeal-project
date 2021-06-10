package shop.ottmeal.batch.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tv")
public class Tv {

    @Id
    @GeneratedValue
    private Long idx;

    private String backdropPath;
    private String createdBy;
    private String episodeRunTime;
    private String firstAirDate;
    private String genres;
    private String homepage;
    private String Id;
    private String inProduction;
    private String languages;
    private String lastAirDate;
    private String lastEpisodeToAir;
    private String name;
    private String nextEpisodeToAir;
    private String networks;
    private String numberOfEpisodes;
    private String numberOfSeasons;
    private String originCountry;
    private String originalLanguage;
    private String originalName;
    private String overview;
    private String popularity;
    private String posterPath;
    private String productionCompanies;
    private String productionCountries;
    private String seasons;
    private String spokenLanguages;
    private String status;
    private String tagline;
    private String type;
    private String voteAverage;
    private String voteCount;



//    backdrop_path: null,
//    created_by: [],
//    episode_run_time: [60],
//    first_air_date: "2002-12-16",
//    genres: [
//        {
//        id: 99,
//        name: "다큐멘터리"
//        },
//        {
//        id: 35,
//        name: "코미디"
//        }
//    ],
//    homepage: "",
//    id: 929,
//    in_production: false,
//    languages: [ "en" ],
//    last_air_date: "2002-12-20",
//    last_episode_to_air: {
//        air_date: "2002-12-20",
//        episode_number: 10,
//        id: 50574,
//        name: "",
//        overview: "",
//        production_code: "",
//        season_number: 1,
//        still_path: null,
//        vote_average: 0.0,
//        vote_count: 0
//    },
//    name: "I Love the '80s",
//    next_episode_to_air: null,
//    networks: [
//        {
//            name: "VH1",
//            id: 158,
//            logo_path: "/2IUI7PwPokLMbXwwJndNH4sqEFn.png",
//            origin_country: "US"
//        }
//    ],
//    number_of_episodes: 10,
//    number_of_seasons: 1,
//    origin_country: [ "US" ],
//    original_language: "en",
//    original_name: "I Love the '80s",
//    overview: "",
//    popularity: 2.003,
//    poster_path: null,
//    production_companies: [],
//    production_countries: [],
//    seasons: [
//        {
//            air_date: "2002-12-16",
//            episode_count: 10,
//            id: 2698,
//            name: "Season 1",
//            overview: "",
//            poster_path: null,
//            season_number: 1
//        }
//    ],
//    spoken_languages: [
//        {
//        english_name: "English",
//        iso_639_1: "en",
//        name: "English"
//        }
//    ],
//    status: "Ended",
//    tagline: "",
//    type: "Scripted",
//    vote_average: 9.0,
//    vote_count: 5
}
