package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.domain.MovieProductionCompany;

public interface MovieProductionCompanyRepository extends JpaRepository<MovieProductionCompany, Long> {
}
