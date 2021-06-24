package shop.ottmeal.batch.module.trending.job.movie.step.writer;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.repository.*;

import java.util.List;

@RequiredArgsConstructor
public class TrendingMovieItemWriter implements ItemWriter<Movie> {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final ProductionCountryRepository productionCountryRepository;
    private final SpokenLanguageRepository spokenLanguageRepository;

    @Override
    public void write(List<? extends Movie> movies) throws Exception {
        movies.stream().forEach(this::saveAll);
    }

    private void saveAll(Movie movie) {
        movieRepository.save(movie);
        genreRepository.saveAll(movie.getGenres());
        productionCompanyRepository.saveAll(movie.getProductionCompanies());
        productionCountryRepository.saveAll(movie.getProductionCountries());
        spokenLanguageRepository.saveAll(movie.getSpokenLanguages());
    }
}
