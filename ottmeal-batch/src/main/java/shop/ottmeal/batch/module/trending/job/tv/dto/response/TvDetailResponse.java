package shop.ottmeal.batch.module.trending.job.tv.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.common.TimeUtils;
import shop.ottmeal.batch.domain.*;
import shop.ottmeal.batch.module.trending.job.common.dto.GenreResponse;
import shop.ottmeal.batch.module.trending.job.common.dto.ProductionCompanyResponse;
import shop.ottmeal.batch.module.trending.job.common.dto.ProductionCountryResponse;
import shop.ottmeal.batch.module.trending.job.common.dto.SpokenLanguageResponse;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvDetailResponse {

    @JsonProperty("backdropPath")
    private String backdrop_path;

    private LocalDateTime first_air_date;

    private String homepage;

    private Long id;

    private Boolean in_production;

    private LocalDateTime last_air_date;

    private String name;

    private String next_episode_to_air;

    private Integer number_of_episodes;

    private Integer number_of_seasons;

    private String original_language;

    private String original_name;

    private String overview;

    private Double popularity;

    private String poster_path;

    private String status;

    private String tagline;

    private String type;

    private Double vote_average;

    private Integer vote_count;

    private List<CreatedBy> created_by;

    private List<Integer> episode_run_time;

    private List<Genre> genres;

    private List<String> languages;

    private LastEpisodeToAir last_episode_to_air;

    private List<Network> networks;

    private List<String> origin_country;

    private List<ProductionCompany> production_companies;

    private List<ProductionCountry> production_countries;

    private List<Season> seasons;

    private List<SpokenLanguage> spoken_languages;

    public static Tv toEntity(TvDetailResponse tvDetailResponse) {
        Tv tv = Tv.builder()
                .backdropPath(tvDetailResponse.getBackdrop_path())
                .firstAirDate(tvDetailResponse.getFirst_air_date())
                .homepage(tvDetailResponse.getHomepage())
                .id(tvDetailResponse.getId())
                .inProduction(tvDetailResponse.getIn_production())
                .lastAirDate(tvDetailResponse.getLast_air_date())
                .name(tvDetailResponse.getName())
                .nextEpisodeToAir(tvDetailResponse.getNext_episode_to_air())
                .numberOfEpisodes(tvDetailResponse.getNumber_of_episodes())
                .numberOfSeasons(tvDetailResponse.getNumber_of_seasons())
                .originalLanguage(tvDetailResponse.getOriginal_language())
                .originalName(tvDetailResponse.getOriginal_name())
                .overview(tvDetailResponse.getOverview())
                .popularity(tvDetailResponse.getPopularity())
                .posterPath(tvDetailResponse.getPoster_path())
                .status(tvDetailResponse.getStatus())
                .tagline(tvDetailResponse.getTagline())
                .type(tvDetailResponse.getType())
                .voteAverage(tvDetailResponse.getVote_average())
                .voteCount(tvDetailResponse.getVote_count())
                .createdBy(tvDetailResponse.getCreated_by())
                .episodeRunTime(tvDetailResponse.getEpisode_run_time())
                .genres(tvDetailResponse.getGenres())
                .languages(tvDetailResponse.getLanguages())
                .lastEpisodeToAir(tvDetailResponse.getLast_episode_to_air())
                .networks(tvDetailResponse.getNetworks())
                .originCountry(tvDetailResponse.getOrigin_country())
                .productionCompanies(tvDetailResponse.getProduction_companies())
                .productionCountries(tvDetailResponse.getProduction_countries())
                .seasons(tvDetailResponse.getSeasons())
                .spokenLanguages(tvDetailResponse.getSpoken_languages())
                .build();

//        movie.getGenres().stream().forEach(genre -> genre.setMovie(movie));
//        movie.getProductionCompanies().stream().forEach(productionCompany -> productionCompany.setMovie(movie));
//        movie.getProductionCountries().stream().forEach(productionCountry -> productionCountry.setMovie(movie));
//        movie.getSpokenLanguages().stream().forEach(spokenLanguage -> spokenLanguage.setMovie(movie));

        return tv;
    }
}
