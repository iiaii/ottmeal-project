package shop.ottmeal.batch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ottmeal.batch.module.movie.job.latest.dto.response.LatestMovieResult;
import shop.ottmeal.batch.repository.MovieRepository;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public void saveMovie(LatestMovieResult latestMovieResult) {

    }

}
