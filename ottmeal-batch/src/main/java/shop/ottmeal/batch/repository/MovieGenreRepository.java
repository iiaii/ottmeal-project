package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.Genre;

public interface MovieGenreRepository extends JpaRepository<Genre, Long> {
}
