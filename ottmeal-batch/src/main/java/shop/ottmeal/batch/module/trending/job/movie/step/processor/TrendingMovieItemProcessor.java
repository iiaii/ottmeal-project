package shop.ottmeal.batch.module.trending.job.movie.step.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.common.RequestGenerator;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResult;
import shop.ottmeal.batch.module.trending.job.movie.dto.MovieDetailResponse;

@RequiredArgsConstructor
public class TrendingMovieItemProcessor implements ItemProcessor<TrendingResult, Movie> {

    private final RequestGenerator requestGenerator;
    private final RestTemplate restTemplate;


    @Override
    public Movie process(TrendingResult item) throws Exception {
        return MovieDetailResponse.toEntity(request(item.getId()));
    }

    private MovieDetailResponse request(Long id) {
        Request<MovieDetailResponse> request = requestGenerator.getMovieDetailRequest(id);
        return restTemplate.exchange(request.getUrl(), request.getHttpMethod(), null, request.getResponseType())
                .getBody();
    }
}


