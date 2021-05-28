package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.MovieGenre;

public interface MovieGenreRepository extends JpaRepository<MovieGenre, Long> {
}
