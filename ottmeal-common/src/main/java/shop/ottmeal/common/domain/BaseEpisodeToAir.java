package shop.ottmeal.common.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseEpisodeToAir extends BaseEntity {

    protected LocalDateTime airDate;

    protected Integer episodeNumber;

//    @Column(name = "episode_to_air_id", unique = true)
    protected Long id;

    protected String name;

    @Lob
    protected String overview;

    protected String productionCode;

    protected Integer seasonNumber;

    protected String stillPath;

    protected Double voteAverage;

    protected Integer voteCount;


}