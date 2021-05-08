package shop.ottmeal.batch.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie")
@Slf4j
public class Movie {

    @Id @GeneratedValue
    private Long idx;

    private Long id;
    private String title;
    private String overview;
    private String posterImgUrl;
    private List<Genre> genres;

    private Double popularity;
    private Double voteAverage;
    private Long voteCount;

    private Language language;

}
