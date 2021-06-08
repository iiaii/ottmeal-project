package shop.ottmeal.batch.module.trending.job.tv.step.writer;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.repository.*;

import java.util.List;

@RequiredArgsConstructor
public class TrendingTvItemWriter implements ItemWriter<Movie> {

    private final MovieRepository movieRepository;
    private final MovieGenreRepository movieGenreRepository;
    private final MovieProductionCompanyRepository movieProductionCompanyRepository;
    private final MovieProductionCountryRepository movieProductionCountryRepository;
    private final MovieSpokenLanguageRepository movieSpokenLanguageRepository;

    @Override
    public void write(List<? extends Movie> movies) throws Exception {
        movies.stream().forEach(this::saveAll);
    }

    private void saveAll(Movie movie) {
        movieRepository.save(movie);
        movieGenreRepository.saveAll(movie.getGenres());
        movieProductionCompanyRepository.saveAll(movie.getProductionCompanies());
        movieProductionCountryRepository.saveAll(movie.getProductionCountries());
        movieSpokenLanguageRepository.saveAll(movie.getSpokenLanguages());
    }
}
