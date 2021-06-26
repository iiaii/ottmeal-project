package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.EpisodeToAir;

public interface LastEpisodeToAirRepository extends JpaRepository<EpisodeToAir, Long> {
}
