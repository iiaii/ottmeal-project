package shop.ottmeal.common.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseSeason extends BaseEntity {

    protected LocalDateTime airDate;

    protected Integer episodeCount;

//    @Column(name = "season_id", unique = true)
    protected Long id;

    protected String name;

    @Lob
    protected String overview;

    protected String posterPath;

    protected Integer seasonNumber;

}
