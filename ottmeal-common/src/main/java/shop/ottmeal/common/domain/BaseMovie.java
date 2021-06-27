package shop.ottmeal.common.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseMovie extends BaseEntity {

    protected Boolean adult;

    protected String backdropPath;

    protected Long budget;

    protected String homepage;

    protected Long id;

    protected String imdbId;

    protected String originalLanguage;

    protected String originalTitle;

    @Lob
    protected String overview;

    protected Double popularity;

    protected String posterPath;

    protected LocalDateTime releaseDate;

    protected Long revenue;

    protected Integer runtime;

    protected String status;

    protected String tagline;

    protected String title;

    protected Boolean video;

    protected Double voteAverage;

    protected Long voteCount;
}
