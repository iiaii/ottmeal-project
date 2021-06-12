package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.ProductionCompany;

public interface MovieProductionCompanyRepository extends JpaRepository<ProductionCompany, Long> {
}
