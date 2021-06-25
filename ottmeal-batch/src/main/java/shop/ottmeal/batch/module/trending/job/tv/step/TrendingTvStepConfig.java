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
import shop.ottmeal.batch.domain.Tv;
import shop.ottmeal.batch.enums.MediaType;
import shop.ottmeal.batch.enums.TimeWindow;
import shop.ottmeal.batch.module.trending.job.common.TrendingItemReader;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResult;
import shop.ottmeal.batch.module.trending.job.tv.step.processor.TrendingTvItemProcessor;
import shop.ottmeal.batch.module.trending.job.tv.step.writer.TrendingTvItemWriter;
import shop.ottmeal.batch.repository.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TrendingTvStepConfig {
    public static final String STEP_NAME = "trendingTvStep";

    private final RestTemplate restTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlatformTransactionManager transactionManager;
    private final TvRepository tvRepository;
    private final GenreRepository genreRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final ProductionCountryRepository productionCountryRepository;
    private final SpokenLanguageRepository spokenLanguageRepository;
    private final LastEpisodeToAirRepository lastEpisodeToAirRepository;
    private final NetworkRepository networkRepository;
    private final SeasonRepository seasonRepository;

    @Bean("trendingTvReader")
    public TrendingItemReader trendingTvReader() {
        return new TrendingItemReader(restTemplate, RequestGenerator.getTrendingRequest(MediaType.Tv, TimeWindow.Day));
    }

    @Bean
    public TrendingTvItemProcessor trendingTvProcessor() {
        return new TrendingTvItemProcessor(restTemplate);
    }

    @Bean
    public TrendingTvItemWriter trendingTvWriter() {
        return new TrendingTvItemWriter(tvRepository, genreRepository, productionCompanyRepository,
                productionCountryRepository, spokenLanguageRepository, lastEpisodeToAirRepository, networkRepository, seasonRepository);
    }

    @Bean(name = STEP_NAME)
    public Step step() {
        return stepBuilderFactory.get(STEP_NAME)
                .transactionManager(transactionManager)
                .<TrendingResult, Tv>chunk(20)
                .reader(trendingTvReader())
                .processor(trendingTvProcessor())
                .writer(trendingTvWriter())
                .faultTolerant()
                .retryLimit(0)
                .build();
    }
}
