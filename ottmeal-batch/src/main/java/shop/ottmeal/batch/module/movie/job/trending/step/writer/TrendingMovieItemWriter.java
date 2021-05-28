package shop.ottmeal.batch.module.movie.job.trending.step.writer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.repository.*;

import java.util.List;

@RequiredArgsConstructor
public class TrendingMovieItemWriter implements ItemWriter<Movie> {

    private final MovieRepository movieRepository;
//    private final MovieGenreRepository movieGenreRepository;
//    private final MovieProductionCompanyRepository movieProductionCompanyRepository;
//    private final MovieProductionCountryRepository movieProductionCountryRepository;
//    private final MovieSpokenLanguageRepository movieSpokenLanguageRepository;

    @Override
    public void write(List<? extends Movie> items) throws Exception {
        items.stream()
                .forEach(movieRepository::save);

    }
}
