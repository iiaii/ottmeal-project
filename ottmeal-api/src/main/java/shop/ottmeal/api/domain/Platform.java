package shop.ottmeal.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.ottmeal.common.domain.BasePlatform;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "platform")
@Slf4j
public class Platform extends BasePlatform {

    @Builder
    public Platform(Long idx, String name, List<Movie> movies, List<Series> series) {
        super(idx, name);
        this.movies = movies;
        this.series = series;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "platform")
    private List<Movie> movies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "platform")
    private List<Series> series;
}
