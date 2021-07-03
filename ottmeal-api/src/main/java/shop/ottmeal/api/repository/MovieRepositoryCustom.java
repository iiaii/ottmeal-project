package shop.ottmeal.api.repository;

import org.springframework.data.domain.Page;
import shop.ottmeal.api.domain.Movie;

public interface MovieRepositoryCustom {

    Page<Movie> getPopularMovies();
}
