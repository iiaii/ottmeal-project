package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.MovieProductionCountry;

public interface MovieProductionCountryRepository extends JpaRepository<MovieProductionCountry, Long> {
}
