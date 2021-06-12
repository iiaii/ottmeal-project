package shop.ottmeal.batch.module.trending.job.common;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.enums.Param;
import shop.ottmeal.batch.module.trending.job.movie.dto.response.TrendingResponse;
import shop.ottmeal.batch.module.trending.job.movie.dto.response.TrendingResult;

public class TrendingItemReader implements ItemReader<TrendingResult> {

    private int index;
    private TrendingResponse response;
    private final int totalPages;
    private final RestTemplate restTemplate;
    private final Request<TrendingResponse> request;

    public TrendingItemReader(RestTemplate restTemplate, Request<TrendingResponse> request) {
        this.response = request();
        this.totalPages = response.getTotal_pages();
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
            int page = Integer.parseInt(request.getParams().getParam(Param.PAGE));
            if (totalPages > page) {
                request.getParams().addValueIfNumber(Param.PAGE);
                response = request();
            } else {
                return null;
            }
        }

        return (TrendingResult) response.getResults().get(index++);
    }

    private TrendingResponse request() {
        return restTemplate.exchange(request.getUrl(), request.getHttpMethod(), null, request.getResponseType())
                .getBody();
    }
}
