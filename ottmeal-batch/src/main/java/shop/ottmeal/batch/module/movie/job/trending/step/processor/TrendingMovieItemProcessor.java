package shop.ottmeal.batch.module.movie.job.trending.step.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.MovieDetailResponse;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.TrendingResult;

@Slf4j
@RequiredArgsConstructor
public class TrendingMovieItemProcessor implements ItemProcessor<TrendingResult, Movie> {

    private RestTemplate restTemplate;
    private Request<MovieDetailResponse> request;

    public TrendingMovieItemProcessor(RestTemplate restTemplate, Request<MovieDetailResponse> request) {
        this.restTemplate = restTemplate;
        this.request = request;
    }

    @Override
    public Movie process(TrendingResult item) throws Exception {
        return Movie.toEntity(request());
    }

    private MovieDetailResponse request() {
        return restTemplate.exchange(request.getUrl(), request.getHttpMethod(), null, request.getResponseType())
                .getBody();
    }
}


