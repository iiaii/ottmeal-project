package shop.ottmeal.batch.module.trending.job.tv.step;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;
import shop.ottmeal.batch.common.RequestGenerator;
import shop.ottmeal.batch.enums.MediaType;
import shop.ottmeal.batch.enums.TimeWindow;
import shop.ottmeal.batch.domain.Movie;
import shop.ottmeal.batch.module.trending.job.movie.dto.response.TrendingResult;
import shop.ottmeal.batch.module.trending.job.movie.step.processor.TrendingMovieItemProcessor;
import shop.ottmeal.batch.module.trending.job.common.TrendingItemReader;
import shop.ottmeal.batch.module.trending.job.movie.step.writer.TrendingMovieItemWriter;
import shop.ottmeal.batch.repository.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TrendingTvStepConfig {
    public static final String STEP_NAME = "trendingTvStep";

    private final RestTemplate restTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlatformTransactionManager transactionManager;
    private final MovieRepository movieRepository;
    private final MovieGenreRepository movieGenreRepository;
    private final MovieProductionCompanyRepository movieProductionCompanyRepository;
    private final MovieProductionCountryRepository movieProductionCountryRepository;
    private final MovieSpokenLanguageRepository movieSpokenLanguageRepository;

    @Bean
    // @StepScope
    public TrendingItemReader trendingTvReader() {
        return new TrendingItemReader(restTemplate, RequestGenerator.getTrendingRequest(MediaType.Tv, TimeWindow.Day));
    }

    @Bean
    public TrendingMovieItemProcessor trendingTvProcessor() {
        return new TrendingMovieItemProcessor(restTemplate);
    }

    @Bean
    public TrendingMovieItemWriter trendingTvWriter() {
        return new TrendingMovieItemWriter(movieRepository, movieGenreRepository, movieProductionCompanyRepository, movieProductionCountryRepository, movieSpokenLanguageRepository);
    }

    @Bean(name = STEP_NAME)
    public Step step() {
        return stepBuilderFactory.get(STEP_NAME)
                .transactionManager(transactionManager)
                .<TrendingResult, Movie>chunk(20)
                .reader(trendingTvReader())
                .processor(trendingTvProcessor())
                .writer(trendingTvWriter())
                .faultTolerant()
                .retryLimit(0)
                .build();
    }
}
