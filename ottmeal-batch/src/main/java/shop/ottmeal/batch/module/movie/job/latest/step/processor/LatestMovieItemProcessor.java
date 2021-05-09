package shop.ottmeal.batch.module.movie.job.latest.step.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.latest.dto.LatestMovieResponse;

@Slf4j
public class LatestMovieItemProcessor implements ItemProcessor<LatestMovieResponse, Movie> {


    @Override
    public Movie process(LatestMovieResponse item) throws Exception {
        log.info("title: " + item.getTitle());


        Movie movie = Movie.builder()
                .id(item.getId())
                .title(item.getTitle())
                .build();


        return movie;
    }
}
