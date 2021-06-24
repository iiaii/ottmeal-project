package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.SpokenLanguage;

public interface SpokenLanguageRepository extends JpaRepository<SpokenLanguage, Long> {
}
