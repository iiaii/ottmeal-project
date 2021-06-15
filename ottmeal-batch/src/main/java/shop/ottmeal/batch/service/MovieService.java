package shop.ottmeal.batch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResult;
import shop.ottmeal.batch.repository.MovieRepository;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public void saveMovie(TrendingResult trendingResult) {

    }

}
