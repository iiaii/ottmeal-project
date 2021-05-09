package shop.ottmeal.batch.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
@Slf4j
public class Movie {

    @Id @GeneratedValue
    @Column(name = "")
    private Long idx;

    private Long id;
    private String title;
    private String overview;
    private String posterImgUrl;

    @ElementCollection
    private Set<String> genres = new HashSet<>();

    private Double popularity;
    private Double voteAverage;
    private Long voteCount;

    private Language language;

}
