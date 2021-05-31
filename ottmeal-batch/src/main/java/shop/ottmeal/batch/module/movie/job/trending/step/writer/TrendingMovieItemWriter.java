package shop.ottmeal.batch.module.movie.job.trending.step.writer;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.repository.*;

import java.util.List;

@RequiredArgsConstructor
public class TrendingMovieItemWriter implements ItemWriter<Movie> {

    private final MovieRepository movieRepository;
    private final MovieGenreRepository movieGenreRepository;
    private final MovieProductionCompanyRepository movieProductionCompanyRepository;
    private final MovieProductionCountryRepository movieProductionCountryRepository;
    private final MovieSpokenLanguageRepository movieSpokenLanguageRepository;

    @Override
    public void write(List<? extends Movie> movies) throws Exception {
        movies.stream()
                .forEach(movie -> {
//                    movie.getGenres().stream().forEach(movieGenreRepository::save);
//                    movie.getProductionCompanies().stream().forEach(movieProductionCompanyRepository::save);
//                    movie.getProductionCountries().stream().forEach(movieProductionCountryRepository::save);
//                    movie.getSpokenLanguages().stream().forEach(movieSpokenLanguageRepository::save);
                    movieRepository.save(movie);
                });

    }
}
