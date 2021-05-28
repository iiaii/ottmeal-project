package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MovieGenre {

    @Id
    @GeneratedValue
    private Long idx;

    private Long id;

    private String name;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx", insertable = false, updatable = false)
    private Movie movie;

    @Builder
    public MovieGenre(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
