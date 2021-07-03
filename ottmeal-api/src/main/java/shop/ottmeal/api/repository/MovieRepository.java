package shop.ottmeal.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.api.domain.Movie;

public interface MovieRepository extends JpaRepository <Movie, Long>, MovieRepositoryCustom {
}
