package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.CreatedBy;
import shop.ottmeal.batch.domain.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
