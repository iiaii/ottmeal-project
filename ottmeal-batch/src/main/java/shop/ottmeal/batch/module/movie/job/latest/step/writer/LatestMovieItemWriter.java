package shop.ottmeal.batch.module.movie.job.latest.step.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import shop.ottmeal.batch.domain.Movie;

import java.util.List;

@Slf4j
public class LatestMovieItemWriter implements ItemWriter<Movie> {

    @Override
    public void write(List<? extends Movie> items) throws Exception {
        log.info("- title = " + items.get(0).getTitle());
    }
}
