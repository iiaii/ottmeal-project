package shop.ottmeal.batch.module.movie.job.trending.step.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.domain.BaseMedia;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.BaseResponse;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.TrendingResult;

@Slf4j
@RequiredArgsConstructor
public class TrendingMovieItemProcessor <Response extends BaseResponse, Result extends BaseMedia> implements ItemProcessor<TrendingResult, Result> {

    private RestTemplate restTemplate;
    private Request<Response> request;

    public TrendingMovieItemProcessor(RestTemplate restTemplate, Request<Response> request) {
        this.restTemplate = restTemplate;
        this.request = request;
    }

    @Override
    public Result process(TrendingResult item) throws Exception {
        Response result = request();

        BaseMedia

        return (Result) movie;
    }

    private Response request() {
        return restTemplate.exchange(request.getUrl(), request.getHttpMethod(), null, request.getResponseType())
                .getBody();
    }
}


