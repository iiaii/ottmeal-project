package shop.ottmeal.batch.module.movie.job.trending.step.reader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.BaseResponse;

@Slf4j
@RequiredArgsConstructor
public class TrendingItemReader <Response extends BaseResponse, Result> implements ItemReader<Result> {

    private int index;
    private RestTemplate restTemplate;
    private Request<Response> request;
    private Response response;

    public TrendingItemReader(RestTemplate restTemplate, Request<Response> request) {
        this.index = 0;
        this.restTemplate = restTemplate;
        this.request = request;
        this.response = request();
    }

    @Override
    public Result read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        response = response.getResults().isEmpty()
                ? request()
                : response;

        return (Result) response.getResults().get(index++);
    }

    private Response request() {
        return restTemplate.exchange(request.getUrl(), request.getHttpMethod(), null, request.getResponseType())
                .getBody();

    }
}
