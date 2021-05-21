package shop.ottmeal.batch.module.movie.job.latest.step;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.latest.dto.response.LatestMovieResult;
import shop.ottmeal.batch.module.movie.job.latest.step.processor.LatestMovieItemProcessor;
import shop.ottmeal.batch.module.movie.job.latest.step.reader.LatestMovieItemReader;
import shop.ottmeal.batch.module.movie.job.latest.step.writer.LatestMovieItemWriter;
import shop.ottmeal.batch.repository.MovieRepository;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LatestMovieJobStepConfig {
    public static final String STEP_NAME = "latestMovieStep";

    private final RestTemplate restTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlatformTransactionManager transactionManager;
    private final MovieRepository movieRepository;

    @Bean
    // @StepScope
    public LatestMovieItemReader latestMovieReader() {
        return new LatestMovieItemReader(restTemplate);
    }

    @Bean
    public LatestMovieItemProcessor latestMovieProcessor() {
        return new LatestMovieItemProcessor(restTemplate);
    }

    @Bean
    public LatestMovieItemWriter latestMovieWriter() {
        return new LatestMovieItemWriter(movieRepository);
    }

    @Bean(name = STEP_NAME)
    public Step step() {
        // BatchHelper.createStepName(this.getClass())
        return stepBuilderFactory.get(STEP_NAME)
                .transactionManager(this.transactionManager)
                .<LatestMovieResult, Movie>chunk(1)
                .reader(latestMovieReader())
                .processor(latestMovieProcessor())
                .writer(latestMovieWriter())
                .faultTolerant()
                .retryLimit(0)
                .build();
    }
}
