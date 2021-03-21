//package shop.ottmeal.batch.movie;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//import shop.ottmeal.batch.component.JobSharedDataStore;
//
//@Slf4j
//@Configuration
//public class LatestMovieStepConfig {
//    public static final String STEP_NAME = "latestMovieStep";
//
//    private final StepBuilderFactory stepBuilderFactory;
//    private final PlatformTransactionManager transactionManager;
//
//    private final JobSharedDataStore<String> latestMovieReminderStore;
//
//    public LatestMovieStepConfig(
//            StepBuilderFactory stepBuilderFactory,
//            @Qualifier("movieTransactionManager") PlatformTransactionManager transactionManager,
//            @Qualifier("latestMovieReminderStore") JobSharedDataStore<String> latestMovieReminderStore) {
//        this.stepBuilderFactory = stepBuilderFactory;
//        this.latestMovieReminderStore = latestMovieReminderStore;
//    }
//}
