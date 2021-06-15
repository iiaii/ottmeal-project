package shop.ottmeal.batch.module.trending.job.tv.step.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.common.RequestGenerator;
import shop.ottmeal.batch.enums.MediaType;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.trending.job.movie.dto.MovieDetailResponse;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResult;

public class TrendingTvItemProcessor implements ItemProcessor<TrendingResult, Movie> {

    private RestTemplate restTemplate;

    public TrendingTvItemProcessor(RestTemplate restTemplate) {
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


