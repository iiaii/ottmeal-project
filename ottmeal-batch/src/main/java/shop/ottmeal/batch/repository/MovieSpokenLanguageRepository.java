package shop.ottmeal.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ottmeal.batch.domain.MovieSpokenLanguage;

public interface MovieSpokenLanguageRepository extends JpaRepository<MovieSpokenLanguage, Long> {
}
