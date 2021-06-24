package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.ottmeal.common.domain.BaseTv;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tv")
public class Tv extends BaseTv {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<CreatedBy> createdBy;


    private List<Integer> episodeRunTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<Genre> genres;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<String> languages;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "tv")
    private LastEpisodeToAir lastEpisodeToAir;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<Network> networks;

    private List<String> originCountry;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<ProductionCompany> productionCompanies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<ProductionCountry> productionCountries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<Season> seasons;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<SpokenLanguage> spokenLanguages;

    @Builder
    public Tv(Long idx, String backdropPath, LocalDateTime firstAirDate, String homepage, Long id, Boolean inProduction, LocalDateTime lastAirDate, String name, String nextEpisodeToAir, Integer numberOfEpisodes, Integer numberOfSeasons, String originalLanguage, String originalName, String overview, Double popularity, String posterPath, String status, String tagline, String type, Double voteAverage, Integer voteCount, List<CreatedBy> createdBy, List<Integer> episodeRunTime, List<Genre> genres, List<String> languages, LastEpisodeToAir lastEpisodeToAir, List<Network> networks, List<String> originCountry, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries, List<Season> seasons, List<SpokenLanguage> spokenLanguages) {
        super(idx, backdropPath, firstAirDate, homepage, id, inProduction, lastAirDate, name, nextEpisodeToAir, numberOfEpisodes, numberOfSeasons, originalLanguage, originalName, overview, popularity, posterPath, status, tagline, type, voteAverage, voteCount);
        this.createdBy = createdBy;
        this.episodeRunTime = episodeRunTime;
        this.genres = genres;
        this.languages = languages;
        this.lastEpisodeToAir = lastEpisodeToAir;
        this.networks = networks;
        this.originCountry = originCountry;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.seasons = seasons;
        this.spokenLanguages = spokenLanguages;
    }
}
