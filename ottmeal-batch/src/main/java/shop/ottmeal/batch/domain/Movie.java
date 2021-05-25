package shop.ottmeal.batch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
@Slf4j
public class Movie extends BaseMedia<Movie> {

    @Id @GeneratedValue
    @Column(name = "")
    private Long idx;
    private boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private int budget;
    private List<MovieGenre> genres;
    private String homepage;
    private Long id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;
    private List<MovieProductionCompany> production_companies;
    private List<MovieProductionCountry> production_countries;
    private String release_date;
    private int revenue;
    private Integer runtime;
    private List<MovieSpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private Double vote_average;
    private int vote_count;

    @Builder
    public Movie(Long idx, boolean adult, String backdrop_path, Object belongs_to_collection, int budget, List<MovieGenre> genres, String homepage, Long id, String imdb_id, String original_language, String original_title, String overview, Double popularity, String poster_path, List<MovieProductionCompany> production_companies, List<MovieProductionCountry> production_countries, String release_date, int revenue, Integer runtime, List<MovieSpokenLanguage> spoken_languages, String status, String tagline, String title, boolean video, Double vote_average, int vote_count) {
        this.idx = idx;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    @Override
    public <Dto> Movie toEntity(Dto dto) {
        MovieDetailResponse movieDetailResponse = (MovieDetailResponse) dto;

        return Movie.builder()
                .id(movieDetailResponse.getId())

                .build();
    }
}
