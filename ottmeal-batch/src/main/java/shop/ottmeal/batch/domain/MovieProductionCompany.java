package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MovieProductionCompany {

    @Id
    @GeneratedValue
    private Long idx;

    private Long id;

    private String logoPath;

    private String name;

    private String originCountry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx", insertable = false, updatable = false)
    private Movie movie;

    @Builder
    public MovieProductionCompany(Long id, String logoPath, String name, String originCountry) {
        this.id = id;
        this.logoPath = logoPath;
        this.name = name;
        this.originCountry = originCountry;
    }
}
