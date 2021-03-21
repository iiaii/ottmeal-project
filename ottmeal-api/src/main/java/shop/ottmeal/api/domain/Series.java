package shop.ottmeal.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.ottmeal.common.domain.BaseSeries;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "series")
@Slf4j
public class Series extends BaseSeries {

    @Builder
    public Series(Long idx, String title, String director, Platform platform, List<Season> seasons) {
        super(idx, title, director);
        this.platform = platform;
        this.seasons = seasons;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Platform platform;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "series")
    private List<Season> seasons;
}
