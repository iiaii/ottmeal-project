package shop.ottmeal.batch.module.trending.job.tv.step.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.common.RequestGenerator;
import shop.ottmeal.batch.domain.Tv;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResult;
import shop.ottmeal.batch.module.trending.job.tv.dto.response.TvDetailResponse;

@RequiredArgsConstructor
public class TrendingTvItemProcessor implements ItemProcessor<TrendingResult, Tv> {

    private final RequestGenerator requestGenerator;
    private final RestTemplate restTemplate;

    @Override
    public Tv process(TrendingResult item) throws Exception {
        return TvDetailResponse.toEntity(request(item.getId()));
    }

    private TvDetailResponse request(Long id) {
        Request<TvDetailResponse> request = requestGenerator.getTvDetailRequest(id);
        return restTemplate.exchange(request.getUrl(), request.getHttpMethod(), null, request.getResponseType())
                .getBody();
    }
}


