package shop.ottmeal.batch.module.movie.job.trending.step.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.repository.MovieRepository;

import java.util.List;

public class TrendingItemWriter implements ItemWriter<Movie> {

    private MovieRepository movieRepository;

    public TrendingItemWriter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void write(List<? extends Movie> items) throws Exception {
        items.stream()
                .forEach(movieRepository::save);

    }
}
