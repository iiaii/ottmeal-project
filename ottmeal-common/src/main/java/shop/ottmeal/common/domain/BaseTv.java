package shop.ottmeal.common.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseTv extends BaseEntity {

    @Id
    @GeneratedValue
    protected Long idx;

    protected String backdropPath;

    protected LocalDateTime firstAirDate;

    protected String homepage;

    protected Long id;

    protected Boolean inProduction;

    protected LocalDateTime lastAirDate;

    protected String name;

    protected Integer numberOfEpisodes;

    protected Integer numberOfSeasons;

    protected String originalLanguage;

    protected String originalName;

    @Lob
    protected String overview;

    protected Double popularity;

    protected String posterPath;

    protected String status;

    protected String tagline;

    protected String type;

    protected Double voteAverage;

    protected Long voteCount;

}
