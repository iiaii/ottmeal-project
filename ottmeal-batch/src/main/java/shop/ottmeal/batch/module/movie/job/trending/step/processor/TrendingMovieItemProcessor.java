package shop.ottmeal.batch.module.movie.job.trending.step.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.common.RequestGenerator;
import shop.ottmeal.batch.common.enums.MediaType;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.MovieDetailResponse;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.TrendingResult;

public class TrendingMovieItemProcessor implements ItemProcessor<TrendingResult, Movie> {

    private RestTemplate restTemplate;

    public TrendingMovieItemProcessor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Movie process(TrendingResult item) throws Exception {
        return MovieDetailResponse.toEntity(request(item.getId()));
    }

    private MovieDetailResponse request(Long id) {
        Request<MovieDetailResponse> request = RequestGenerator.getMovieDetailRequest(MediaType.Movie, id);
        return restTemplate.exchange(request.getUrl(), request.getHttpMethod(), null, request.getResponseType())
                .getBody();
    }
}


