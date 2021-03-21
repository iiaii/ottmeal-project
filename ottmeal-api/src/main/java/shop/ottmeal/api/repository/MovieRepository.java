package shop.ottmeal.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.api.domain.Movie;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryCustom {

    Optional<Movie> getMovieByTitle(String title);
}
