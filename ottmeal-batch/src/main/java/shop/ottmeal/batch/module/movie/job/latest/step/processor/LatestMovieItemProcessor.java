package shop.ottmeal.batch.module.movie.job.latest.step.processor;

import org.springframework.batch.item.ItemProcessor;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.latest.dto.LatestMovieResponse;

public class LatestMovieItemProcessor implements ItemProcessor<LatestMovieResponse, Movie> {


    @Override
    public Movie process(LatestMovieResponse item) throws Exception {
        System.out.println("item.getOriginalTitle() = " + item.getOriginalTitle());

        return null;
    }
}
