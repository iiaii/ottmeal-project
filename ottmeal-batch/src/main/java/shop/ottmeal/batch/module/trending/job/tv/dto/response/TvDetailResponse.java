package shop.ottmeal.batch.module.trending.job.tv.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.batch.common.TimeUtils;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.domain.Tv;
import shop.ottmeal.batch.module.trending.job.common.dto.GenreResponse;
import shop.ottmeal.batch.module.trending.job.common.dto.ProductionCompanyResponse;
import shop.ottmeal.batch.module.trending.job.common.dto.ProductionCountryResponse;
import shop.ottmeal.batch.module.trending.job.common.dto.SpokenLanguageResponse;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvDetailResponse {

    @JsonProperty("adult")
    protected Long idx;

    protected String backdropPath;

    protected LocalDateTime firstAirDate;

    protected String homepage;

    protected Long id;

    protected Boolean inProduction;

    protected LocalDateTime lastAirDate;

    protected String name;

    protected String nextEpisodeToAir;

    protected Integer numberOfEpisodes;

    protected Integer numberOfSeasons;

    protected String originalLanguage;

    protected String originalName;

    @Lob
    protected String overview;

    protected Double popularity;

    protected String posterPath;

    protected String status;

    protected String tagline;

    protected String type;

    protected Double voteAverage;

    protected Integer voteCount;

    public static Tv toEntity(TvDetailResponse tvDetailResponse) {
         Tv.builder()
                .backdropPath(tvDetailResponse.getBackdrop_path())
                .budget(tvDetailResponse.getBudget())
                .genres(tvDetailResponse.getGenres().stream().map(GenreResponse::toEntity).collect(Collectors.toList()))
                .homepage(tvDetailResponse.getHomepage())
                .id(tvDetailResponse.getId())
                .imdbId(tvDetailResponse.getImdb_id())
                .originalLanguage(tvDetailResponse.getOriginal_language())
                .originalTitle(tvDetailResponse.getOriginal_title())
                .overview(tvDetailResponse.getOverview())
                .popularity(tvDetailResponse.getPopularity())
                .posterPath(tvDetailResponse.getPoster_path())
                .productionCompanies(tvDetailResponse.getProduction_companies().stream().map(ProductionCompanyResponse::toEntity).collect(Collectors.toList()))
                .productionCountries(tvDetailResponse.getProduction_countries().stream().map(ProductionCountryResponse::toEntity).collect(Collectors.toList()))
                .releaseDate(TimeUtils.convertFromYyyyMmDd(tvDetailResponse.getRelease_date()))
                .revenue(tvDetailResponse.getRevenue())
                .runtime(tvDetailResponse.getRuntime())
                .spokenLanguages(tvDetailResponse.getSpoken_languages().stream().map(SpokenLanguageResponse::toEntity).collect(Collectors.toList()))
                .status(tvDetailResponse.getStatus())
                .tagline(tvDetailResponse.getTagline())
                .title(tvDetailResponse.getTitle())
                .video(tvDetailResponse.isVideo())
                .voteAverage(tvDetailResponse.getVote_average())
                .voteCount(tvDetailResponse.getVote_count())
                .build();

        movie.getGenres().stream().forEach(genre -> genre.setMovie(movie));
        movie.getProductionCompanies().stream().forEach(productionCompany -> productionCompany.setMovie(movie));
        movie.getProductionCountries().stream().forEach(productionCountry -> productionCountry.setMovie(movie));
        movie.getSpokenLanguages().stream().forEach(spokenLanguage -> spokenLanguage.setMovie(movie));

        return movie;
    }
}
