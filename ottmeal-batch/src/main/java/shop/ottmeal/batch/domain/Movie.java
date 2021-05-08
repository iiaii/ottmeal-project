package shop.ottmeal.batch.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Entity
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
