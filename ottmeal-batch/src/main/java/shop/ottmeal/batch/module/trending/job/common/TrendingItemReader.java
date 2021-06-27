package shop.ottmeal.batch.module.trending.job.common;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.enums.Param;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResponse;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResult;

public class TrendingItemReader implements ItemReader<TrendingResult> {

    private int index;
    private TrendingResponse response;
    private final int totalPages;
    private final RestTemplate restTemplate;
    private final Request<TrendingResponse> request;

    public TrendingItemReader(RestTemplate restTemplate, Request<TrendingResponse> request) {
        this.request = request;
        this.restTemplate = restTemplate;
        this.response = request();
        this.index = 0;
        this.totalPages = 2;
//        this.totalPages = this.response.getTotal_pages();
    }

    @Override
    public TrendingResult read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (response.getResults().size() <= index) {
            int page = Integer.parseInt(request.getParams().getParam(Param.PAGE));
            if (totalPages > page) {
                index = 0;
                request.getParams().addValueIfNumber(Param.PAGE);
                response = request();
            } else {
                request.getParams().resetValueIfNumber(Param.PAGE);
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
