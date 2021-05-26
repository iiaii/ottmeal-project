package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MovieSpokenLanguage {

    @Id
    @GeneratedValue
    private Long idx;

    private String iso_639_1;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx", insertable = false, updatable = false)
    private Movie movie;

    @Builder
    public MovieSpokenLanguage(String iso_639_1, String name) {
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }
}
