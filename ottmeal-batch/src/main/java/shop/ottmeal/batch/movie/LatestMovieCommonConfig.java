package shop.ottmeal.batch.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.ottmeal.batch.component.JobSharedDataStore;

@Configuration
@RequiredArgsConstructor
public class LatestMovieCommonConfig {

    @Bean("latestMovieReminderStore")
    @JobScope
    public JobSharedDataStore<String> latestMovieReminderStore() {
        return new JobSharedDataStore<>();
    }
}
