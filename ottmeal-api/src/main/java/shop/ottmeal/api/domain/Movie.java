package shop.ottmeal.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.ottmeal.common.domain.BaseMovie;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie extends BaseMovie {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Genre> genres;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<ProductionCompany> productionCompanies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<ProductionCountry> productionCountries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<SpokenLanguage> spokenLanguages;

    @Builder
    public Movie(Boolean adult, String backdropPath, Long budget, String homepage, Long id, String imdbId, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, LocalDateTime releaseDate, Long revenue, Integer runtime, String status, String tagline, String title, Boolean video, Double voteAverage, Long voteCount, List<Genre> genres, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries, List<SpokenLanguage> spokenLanguages) {
        super(adult, backdropPath, budget, homepage, id, imdbId, originalLanguage, originalTitle, overview, popularity, posterPath, releaseDate, revenue, runtime, status, tagline, title, video, voteAverage, voteCount);
        this.genres = genres;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.spokenLanguages = spokenLanguages;
    }
}
