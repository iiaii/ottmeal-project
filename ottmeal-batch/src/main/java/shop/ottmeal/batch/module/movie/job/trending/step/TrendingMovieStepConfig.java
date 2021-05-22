package shop.ottmeal.batch.module.movie.job.trending.step;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.LatestMovieResult;
import shop.ottmeal.batch.module.movie.job.trending.step.processor.LatestMovieItemProcessor;
import shop.ottmeal.batch.module.movie.job.trending.step.reader.LatestMovieItemReader;
import shop.ottmeal.batch.module.movie.job.trending.step.writer.LatestMovieItemWriter;
import shop.ottmeal.batch.repository.MovieRepository;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TrendingMovieStepConfig {
    public static final String STEP_NAME = "latestMovieStep";

    private final RestTemplate restTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlatformTransactionManager transactionManager;
    private final MovieRepository movieRepository;

    @Bean
    // @StepScope
    public LatestMovieItemReader trendingMovieReader() {
        return new LatestMovieItemReader(restTemplate);
    }

    @Bean
    public LatestMovieItemProcessor trendingMovieProcessor() {
        return new LatestMovieItemProcessor(restTemplate);
    }

    @Bean
    public LatestMovieItemWriter trendingMovieWriter() {
        return new LatestMovieItemWriter(movieRepository);
    }

    @Bean(name = STEP_NAME)
    public Step step() {
        // BatchHelper.createStepName(this.getClass())
        return stepBuilderFactory.get(STEP_NAME)
                .transactionManager(this.transactionManager)
                .<LatestMovieResult, Movie>chunk(10)
                .reader(trendingMovieReader())
                .processor(trendingMovieProcessor())
                .writer(trendingMovieWriter())
                .faultTolerant()
                .retryLimit(0)
                .build();
    }
}
