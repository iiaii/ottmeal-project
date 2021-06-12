package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private List<CreatedBy> createdBy;
    private List<Integer> episodeRunTime;
    private LocalDateTime firstAirDate;
    private List<Genre> genres;
    private String homepage;
    private Long id;
    private Boolean inProduction;
    private List<String> languages;
    private LocalDateTime lastAirDate;
    private LastEpisodeToAir lastEpisodeToAir;
    private String name;
    private String nextEpisodeToAir;
    private List<Network> networks;
    private Integer numberOfEpisodes;
    private Integer numberOfSeasons;
    private List<String> originCountry;
    private String originalLanguage;
    private String originalName;
    @Lob
    private String overview;
    private Double popularity;
    private String posterPath;
    private List<ProductionCompany> productionCompanies;
    private List<ProductionCountry> productionCountries;
    private List<Season> seasons;
    private List<SpokenLanguage> spokenLanguages;
    private String status;
    private String tagline;
    private String type;
    private Double voteAverage;
    private Integer voteCount;

    @Builder
    public Tv(String backdropPath, List<CreatedBy> createdBy, List<Integer> episodeRunTime, LocalDateTime firstAirDate, List<Genre> genres, String homepage, Long id, Boolean inProduction, List<String> languages, LocalDateTime lastAirDate, LastEpisodeToAir lastEpisodeToAir, String name, String nextEpisodeToAir, List<Network> networks, Integer numberOfEpisodes, Integer numberOfSeasons, List<String> originCountry, String originalLanguage, String originalName, String overview, Double popularity, String posterPath, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries, List<Season> seasons, List<SpokenLanguage> spokenLanguages, String status, String tagline, String type, Double voteAverage, Integer voteCount) {
        this.backdropPath = backdropPath;
        this.createdBy = createdBy;
        this.episodeRunTime = episodeRunTime;
        this.firstAirDate = firstAirDate;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.inProduction = inProduction;
        this.languages = languages;
        this.lastAirDate = lastAirDate;
        this.lastEpisodeToAir = lastEpisodeToAir;
        this.name = name;
        this.nextEpisodeToAir = nextEpisodeToAir;
        this.networks = networks;
        this.numberOfEpisodes = numberOfEpisodes;
        this.numberOfSeasons = numberOfSeasons;
        this.originCountry = originCountry;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.seasons = seasons;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.type = type;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }
}
