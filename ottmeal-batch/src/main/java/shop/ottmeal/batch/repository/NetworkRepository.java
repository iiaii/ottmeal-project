package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.CreatedBy;
import shop.ottmeal.batch.domain.Network;

public interface NetworkRepository extends JpaRepository<Network, Long> {
}
