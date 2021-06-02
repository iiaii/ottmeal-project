package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx")
    private Movie movie;

    @Builder
    public MovieProductionCompany(Long idx, Long id, String logoPath, String name, String originCountry) {
        this.idx = idx;
        this.id = id;
        this.logoPath = logoPath;
        this.name = name;
        this.originCountry = originCountry;
    }
}
