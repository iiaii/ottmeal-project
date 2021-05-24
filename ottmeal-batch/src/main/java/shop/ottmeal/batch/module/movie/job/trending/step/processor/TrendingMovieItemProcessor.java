package shop.ottmeal.batch.module.movie.job.trending.step.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.Request;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.TrendingResult;

@Slf4j
@RequiredArgsConstructor
public class TrendingMovieItemProcessor implements ItemProcessor<TrendingResult, Movie> {

    private final RestTemplate restTemplate;
    private final Request<>

    @Override
    public Movie process(TrendingResult item) throws Exception {
        restTemplate.exchange("https://api.themoviedb.org/3/movie/" + item.getId() + "" +
                        "?api_key=0b1fe3786795a257dd0648d67445af97",
                HttpMethod.GET,
                null,
                JSONObject.class);

        Movie movie = Movie.builder()
                .id(item.getId())
                .title(item.getTitle())
                .build();


        return movie;
    }
}


