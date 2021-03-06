package shop.ottmeal.common.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseEpisode extends BaseEntity {

    @Column(name = "title")
    protected String title;

    @Column(name = "order")
    protected String order;

    @Column(name = "director")
    protected String director;

    @Column(name = "adult")
    protected boolean adult;
}