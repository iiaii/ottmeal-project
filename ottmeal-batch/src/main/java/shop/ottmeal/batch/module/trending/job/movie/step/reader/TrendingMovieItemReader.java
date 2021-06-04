package shop.ottmeal.batch.module.trending.job.movie.step.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.module.trending.job.movie.dto.response.BaseResponse;
import shop.ottmeal.batch.module.trending.job.movie.dto.response.TrendingResponse;
import shop.ottmeal.batch.module.trending.job.movie.dto.response.TrendingResult;

public class TrendingMovieItemReader implements ItemReader<TrendingResult> {

    private int index;
    private int page;
    private RestTemplate restTemplate;
    private Request<TrendingResponse> request;
    private TrendingResponse response;

    public TrendingMovieItemReader(RestTemplate restTemplate, Request<TrendingResponse> request) {
        this.response = request();
        this.index = 0;
        this.restTemplate = restTemplate;
        this.request = request;
    }

    @Override
    public TrendingResult read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        response = response.getResults().isEmpty()
                ? request()
                : response;

        if (response.getResults().size() <= index) {
            return null;
        }

        return (TrendingResult) response.getResults().get(index++);
    }

    private TrendingResponse request() {
        return restTemplate.exchange(request.getUrl(), request.getHttpMethod(), null, request.getResponseType())
                .getBody();
    }
}
