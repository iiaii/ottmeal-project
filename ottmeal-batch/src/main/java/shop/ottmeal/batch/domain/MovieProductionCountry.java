package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MovieProductionCountry {

    @Id
    @GeneratedValue
    private Long idx;

    private String iso_3166_1;

    private String name;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx")
    private Movie movie;

    @Builder
    public MovieProductionCountry(String iso_3166_1, String name) {
        this.iso_3166_1 = iso_3166_1;
        this.name = name;
    }
}
