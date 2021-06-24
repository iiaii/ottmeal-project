package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.ProductionCountry;

public interface ProductionCountryRepository extends JpaRepository<ProductionCountry, Long> {
}
