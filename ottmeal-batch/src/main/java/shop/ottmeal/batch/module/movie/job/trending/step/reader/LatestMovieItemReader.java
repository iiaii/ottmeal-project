package shop.ottmeal.batch.module.movie.job.trending.step.reader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.LatestMovieResponse;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.LatestMovieResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class LatestMovieItemReader implements ItemReader<LatestMovieResult> {

    private RestTemplate restTemplate;
    private int page;
    private int index;
    private String url;
    private LatestMovieResponse latestMovieResponse;

    public LatestMovieItemReader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.page = 1;
        this.index = 0;
        this.url = getUrl();
        this.latestMovieResponse = null;
    }

    @Override
    public LatestMovieResult read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (Objects.isNull(latestMovieResponse)) {
            latestMovieResponse = request();
        }

        if (latestMovieResponse.getResults().isEmpty()) {
            page++;
            latestMovieResponse = request();
        }

        return latestMovieResponse.getResults().get(index++);
    }

    private LatestMovieResponse request() {
        return restTemplate.exchange(getUrl(), HttpMethod.GET, null, LatestMovieResponse.class)
                .getBody();

    }

    private String getUrl() {
        return "https://api.themoviedb.org/3/discover/movie" +
                "?api_key=0b1fe3786795a257dd0648d67445af97" +
                "&certification_country=KR" +
                "&ott_region=KR" +
                "&sort_by=primary_release_date.desc" +
                "&with_ott_providers=8" +
                "&page=" + page +
                "&vote_average.gte=0" +
                "&vote_average.lte=10" +
                "&release_date.lte=" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
