package shop.ottmeal.api.domain;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<Genre> genres;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "tv")
    protected EpisodeToAir nextEpisodeToAir;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "tv")
    private EpisodeToAir lastEpisodeToAir;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<Network> networks;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<ProductionCompany> productionCompanies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<ProductionCountry> productionCountries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<Season> seasons;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tv")
    private List<SpokenLanguage> spokenLanguages;

    @ElementCollection
    @CollectionTable(
            name = "tv_languages",
            joinColumns = @JoinColumn(name = "tv_idx")
    )
    private List<String> languages;

    @ElementCollection
    @CollectionTable(
            name = "tv_episode_run_time",
            joinColumns = @JoinColumn(name = "tv_idx")
    )
    private List<Integer> episodeRunTime;

    @ElementCollection
    @CollectionTable(
            name = "tv_origin_country",
            joinColumns = @JoinColumn(name = "tv_idx")
    )
    private List<String> originCountry;



    @Builder
    public Tv(String backdropPath, LocalDateTime firstAirDate, String homepage, Long id, Boolean inProduction, LocalDateTime lastAirDate, String name, Integer numberOfEpisodes, Integer numberOfSeasons, String originalLanguage, String originalName, String overview, Double popularity, String posterPath, String status, String tagline, String type, Double voteAverage, Long voteCount, List<CreatedBy> createdBy, List<Genre> genres, EpisodeToAir nextEpisodeToAir, EpisodeToAir lastEpisodeToAir, List<Network> networks, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries, List<Season> seasons, List<SpokenLanguage> spokenLanguages, List<String> languages, List<Integer> episodeRunTime, List<String> originCountry) {
        super(backdropPath, firstAirDate, homepage, id, inProduction, lastAirDate, name, numberOfEpisodes, numberOfSeasons, originalLanguage, originalName, overview, popularity, posterPath, status, tagline, type, voteAverage, voteCount);
        this.createdBy = createdBy;
        this.genres = genres;
        this.nextEpisodeToAir = nextEpisodeToAir;
        this.lastEpisodeToAir = lastEpisodeToAir;
        this.networks = networks;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.seasons = seasons;
        this.spokenLanguages = spokenLanguages;
        this.languages = languages;
        this.episodeRunTime = episodeRunTime;
        this.originCountry = originCountry;
    }
}
