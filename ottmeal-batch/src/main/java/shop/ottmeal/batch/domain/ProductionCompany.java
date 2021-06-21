package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ProductionCompany {

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

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public ProductionCompany(Long id, String logoPath, String name, String originCountry) {
        this.id = id;
        this.logoPath = logoPath;
        this.name = name;
        this.originCountry = originCountry;
    }
}
