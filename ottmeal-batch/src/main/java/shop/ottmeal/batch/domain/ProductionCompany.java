package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.ottmeal.common.domain.BaseProductionCompany;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ProductionCompany extends BaseProductionCompany {

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx")
    private Movie movie;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public ProductionCompany(Long id, String logoPath, String name, String originCountry, Movie movie, Tv tv) {
        super(id, logoPath, name, originCountry);
        this.movie = movie;
        this.tv = tv;
    }
}
