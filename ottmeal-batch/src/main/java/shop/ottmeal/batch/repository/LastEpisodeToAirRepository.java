package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.CreatedBy;
import shop.ottmeal.batch.domain.LastEpisodeToAir;

public interface LastEpisodeToAirRepository extends JpaRepository<LastEpisodeToAir, Long> {
}
