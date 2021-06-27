package shop.ottmeal.batch.module.trending.job.tv.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.common.TimeUtils;
import shop.ottmeal.batch.domain.*;
import shop.ottmeal.batch.module.trending.job.common.dto.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvDetailResponse {

    @JsonProperty("backdrop_path")
    private String backdrop_path;

    @JsonProperty("first_air_date")
    private String first_air_date;

    @JsonProperty("homepage")
    private String homepage;

    private Long id;

    private Boolean in_production;

    private String last_air_date;

    private String name;

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

    private Long vote_count;

    private List<CreatedByResponse> created_by;

    private List<Integer> episode_run_time;

    private List<GenreResponse> genres;

    private List<String> languages;

    private EpisodeToAirResponse next_episode_to_air;

    private EpisodeToAirResponse last_episode_to_air;

    private List<NetworkResponse> networks;

    private List<String> origin_country;

    private List<ProductionCompanyResponse> production_companies;

    private List<ProductionCountryResponse> production_countries;

    private List<SeasonResponse> seasons;

    private List<SpokenLanguageResponse> spoken_languages;

    public static Tv toEntity(TvDetailResponse tvDetailResponse) {
        Tv tv = Tv.builder()
                .backdropPath(tvDetailResponse.getBackdrop_path())
                .firstAirDate(TimeUtils.convertFromYyyyMmDd(tvDetailResponse.getFirst_air_date()))
                .homepage(tvDetailResponse.getHomepage())
                .id(tvDetailResponse.getId())
                .inProduction(tvDetailResponse.getIn_production())
                .lastAirDate(TimeUtils.convertFromYyyyMmDd(tvDetailResponse.getLast_air_date()))
                .name(tvDetailResponse.getName())
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
                .createdBy(tvDetailResponse.getCreated_by().stream().map(CreatedByResponse::toEntity).collect(Collectors.toList()))
                .episodeRunTime(tvDetailResponse.getEpisode_run_time())
                .genres(tvDetailResponse.getGenres().stream().map(GenreResponse::toEntity).collect(Collectors.toList()))
                .languages(tvDetailResponse.getLanguages())
                .nextEpisodeToAir(Objects.isNull(tvDetailResponse.getNext_episode_to_air()) ? null : tvDetailResponse.getNext_episode_to_air().toEntity())
                .lastEpisodeToAir(Objects.isNull(tvDetailResponse.getLast_episode_to_air()) ? null : tvDetailResponse.getLast_episode_to_air().toEntity())
                .networks(tvDetailResponse.getNetworks().stream().map(NetworkResponse::toEntity).collect(Collectors.toList()))
                .originCountry(tvDetailResponse.getOrigin_country())
                .productionCompanies(tvDetailResponse.getProduction_companies().stream().map(ProductionCompanyResponse::toEntity).collect(Collectors.toList()))
                .productionCountries(tvDetailResponse.getProduction_countries().stream().map(ProductionCountryResponse::toEntity).collect(Collectors.toList()))
                .seasons(tvDetailResponse.getSeasons().stream().map(SeasonResponse::toEntity).collect(Collectors.toList()))
                .spokenLanguages(tvDetailResponse.getSpoken_languages().stream().map(SpokenLanguageResponse::toEntity).collect(Collectors.toList()))
                .build();

        tv.getCreatedBy().stream().forEach(createdBy -> createdBy.setTv(tv));
        tv.getGenres().stream().forEach(genre -> genre.setTv(tv));
        if (Objects.nonNull(tv.getNextEpisodeToAir())) {
            tv.getNextEpisodeToAir().setTv(tv);
        }
        if (Objects.nonNull(tv.getLastEpisodeToAir())) {
            tv.getLastEpisodeToAir().setTv(tv);
        }
        tv.getNetworks().stream().forEach(network -> network.setTv(tv));
        tv.getProductionCompanies().stream().forEach(productionCompany -> productionCompany.setTv(tv));
        tv.getProductionCountries().stream().forEach(productionCountry -> productionCountry.setTv(tv));
        tv.getSeasons().stream().forEach(season -> season.setTv(tv));
        tv.getSpokenLanguages().stream().forEach(spokenLanguage -> spokenLanguage.setTv(tv));

        return tv;
    }
}
