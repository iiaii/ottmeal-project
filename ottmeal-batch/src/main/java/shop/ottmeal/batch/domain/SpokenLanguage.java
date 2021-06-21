package shop.ottmeal.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class SpokenLanguage {

    @Id
    @GeneratedValue
    private Long idx;

    private String englishName;

    private String iso_639_1;

    private String name;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_idx")
    private Movie movie;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_idx")
    private Tv tv;

    @Builder
    public SpokenLanguage(String englishName, String iso_639_1, String name) {
        this.englishName = englishName;
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }
}
