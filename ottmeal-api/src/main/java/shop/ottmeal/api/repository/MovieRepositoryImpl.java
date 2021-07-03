package shop.ottmeal.api.repository;

import org.springframework.data.domain.Page;
import shop.ottmeal.api.domain.Movie;

public class MovieRepositoryImpl implements MovieRepositoryCustom {

    private final JpaQuery

    @Override
    public Page<Movie> getPopularMovies() {
        return null;
    }
}
