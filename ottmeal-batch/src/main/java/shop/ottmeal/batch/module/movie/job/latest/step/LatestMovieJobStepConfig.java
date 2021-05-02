package shop.ottmeal.batch.module.movie.job.latest.step;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class LatestMovieJobStepConfig {
    public static final String STEP_NAME = "latestMovieStep";

    private final StepBuilderFactory stepBuilderFactory;
    private final PlatformTransactionManager transactionManager;

    @Bean(name = STEP_NAME)
    public Step step() {
        return stepBuilderFactory.get(STEP_NAME) // BatchHelper.createStepName(this.getClass())
                .transactionManager(this.transactionManager)
                .chunk(10)
                .faultTolerant().retryLimit(0)
                .build();
    }
}
