package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.Tv;

public interface TvRepository extends JpaRepository<Tv, Long> {
}
