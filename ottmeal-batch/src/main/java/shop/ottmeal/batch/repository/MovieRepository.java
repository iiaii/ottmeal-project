package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
