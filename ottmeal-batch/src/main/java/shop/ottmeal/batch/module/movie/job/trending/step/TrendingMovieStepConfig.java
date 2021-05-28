package shop.ottmeal.batch.module.movie.job.trending.step;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.RequestGenerator;
import shop.ottmeal.batch.common.enums.MediaType;
import shop.ottmeal.batch.common.enums.TimeWindow;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.TrendingResult;
import shop.ottmeal.batch.module.movie.job.trending.step.processor.TrendingMovieItemProcessor;
import shop.ottmeal.batch.module.movie.job.trending.step.reader.TrendingItemReader;
import shop.ottmeal.batch.module.movie.job.trending.step.writer.TrendingMovieItemWriter;
import shop.ottmeal.batch.repository.MovieRepository;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TrendingMovieStepConfig {
    public static final String STEP_NAME = "trendingMovieStep";

    private final RestTemplate restTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlatformTransactionManager transactionManager;
    private final MovieRepository movieRepository;

    @Bean
    // @StepScope
    public TrendingItemReader trendingMovieReader() {
        return new TrendingItemReader(restTemplate, RequestGenerator.getTrendingRequest(MediaType.Movie, TimeWindow.Day));
    }

    @Bean
    public TrendingMovieItemProcessor trendingMovieProcessor() {
        return new TrendingMovieItemProcessor(restTemplate);
    }

    @Bean
    public TrendingMovieItemWriter trendingMovieWriter() {
        return new TrendingMovieItemWriter(movieRepository);
    }

    @Bean(name = STEP_NAME)
    public Step step() {
        // BatchHelper.createStepName(this.getClass())
        return stepBuilderFactory.get(STEP_NAME)
                .transactionManager(this.transactionManager)
                .<TrendingResult, Movie>chunk(10)
                .reader(trendingMovieReader())
                .processor(trendingMovieProcessor())
                .writer(trendingMovieWriter())
                .faultTolerant()
                .retryLimit(0)
                .build();
    }
}
