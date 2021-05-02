package shop.ottmeal.batch.module.movie.job.latest.step.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import shop.ottmeal.batch.module.movie.job.latest.dto.LatestMovieDto;


import java.util.LinkedList;

public class LatestMovieReader implements ItemReader<LatestMovieDto> {

    private final LinkedList<LatestMovieDto> movies;

    public LatestMovieReader(LinkedList<LatestMovieDto> movies) {
        this.movies = movies;
    }

    @Override
    public LatestMovieDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
