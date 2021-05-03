package shop.ottmeal.batch.module.movie.job.latest.step;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.reader.RestItemReader;
import shop.ottmeal.batch.module.movie.job.latest.dto.LatestMovieResponse;

@Configuration
@RequiredArgsConstructor
public class LatestMovieJobStepConfig {
    public static final String STEP_NAME = "latestMovieStep";

    private final RestTemplate restTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlatformTransactionManager transactionManager;

    @Bean
    @StepScope
    public RestItemReader<LatestMovieResponse> latestMovieReader() {
        return new RestItemReader<>(this.restTemplate,
                "https://api.themoviedb.org/3/discover/movie?api_key=0b1fe3786795a257dd0648d67445af97",
                LatestMovieResponse[].class,
                HttpMethod.GET);
    }

    @Bean(name = STEP_NAME)
    public Step step() {
        return stepBuilderFactory.get(STEP_NAME) // BatchHelper.createStepName(this.getClass())
                .transactionManager(this.transactionManager)
                .chunk(10)
                .faultTolerant().retryLimit(0)
                .build();
    }
}
