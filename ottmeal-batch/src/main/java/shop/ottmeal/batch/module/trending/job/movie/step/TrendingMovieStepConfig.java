package shop.ottmeal.batch.module.trending.job.movie.step;

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
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResult;
import shop.ottmeal.batch.module.trending.job.movie.step.processor.TrendingMovieItemProcessor;
import shop.ottmeal.batch.module.trending.job.common.TrendingItemReader;
import shop.ottmeal.batch.module.trending.job.movie.step.writer.TrendingMovieItemWriter;
import shop.ottmeal.batch.repository.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TrendingMovieStepConfig {
    public static final String STEP_NAME = "trendingMovieStep";

    private final RequestGenerator requestGenerator;
    private final RestTemplate restTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlatformTransactionManager transactionManager;
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final ProductionCountryRepository productionCountryRepository;
    private final SpokenLanguageRepository spokenLanguageRepository;

    @Bean("trendingMovieReader")
    public TrendingItemReader trendingMovieReader() {
        return new TrendingItemReader(restTemplate, requestGenerator.getTrendingRequest(MediaType.Movie, TimeWindow.Day));
    }

    @Bean
    public TrendingMovieItemProcessor trendingMovieProcessor() {
        return new TrendingMovieItemProcessor(requestGenerator, restTemplate);
    }

    @Bean
    public TrendingMovieItemWriter trendingMovieWriter() {
        return new TrendingMovieItemWriter(movieRepository, genreRepository, productionCompanyRepository, productionCountryRepository, spokenLanguageRepository);
    }

    @Bean(name = STEP_NAME)
    public Step step() {
        return stepBuilderFactory.get(STEP_NAME)
                .transactionManager(transactionManager)
                .<TrendingResult, Movie>chunk(10)
                .reader(trendingMovieReader())
                .processor(trendingMovieProcessor())
                .writer(trendingMovieWriter())
                .faultTolerant()
                .retryLimit(0)
                .build();
    }
}
