package shop.ottmeal.batch.module.movie.job.latest.step.writer;

import org.springframework.batch.item.ItemWriter;
import shop.ottmeal.batch.domain.Movie;

import java.util.List;

public class LatestMovieItemWriter implements ItemWriter<Movie> {

    @Override
    public void write(List<? extends Movie> items) throws Exception {

    }
}
