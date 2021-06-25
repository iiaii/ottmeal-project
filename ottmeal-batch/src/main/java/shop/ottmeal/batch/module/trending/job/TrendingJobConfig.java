package shop.ottmeal.batch.module.trending.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.ottmeal.batch.module.trending.job.movie.step.TrendingMovieStepConfig;
import shop.ottmeal.batch.module.trending.job.tv.step.TrendingTvStepConfig;

@Slf4j
@Configuration
public class TrendingJobConfig {
    public static final String JOB_NAME = "trendingJob";

//    @Value("${job.movieJob.latest.trigger")
//    private String trigger;
//
//    @Bean("latestMovieJobDetailFactoryBean")
//    public JobDetailFactoryBean jobDetailFactoryBean(@Qualifier(JOB_NAME) Job job) {
//        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
//
//        // QuartzSpringBatchCombiner.merge();
//
//        return jobDetailFactory;
//    }
//
//    @Bean("latestMovieJobCronTriggerFactoryBean")
//    public CronTriggerFactoryBean cronTriggerFactoryBean(@Qualifier(JOB_NAME) Job job) {
//        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
//        cronTriggerFactoryBean.setJobDetail(Objects.requireNonNull(jobDetailFactoryBean(job).getObject()));
//        cronTriggerFactoryBean.setName(job.getName()); // SchedulerNameGenerator.generateQuartzTriggerName(job.getName())
//        cronTriggerFactoryBean.setGroup("");  // SchedulerNameGenerator.generateQuartzTriggerGroupName());
//        cronTriggerFactoryBean.setCronExpression(trigger);
//        return cronTriggerFactoryBean;
//    }

    @Bean(JOB_NAME)
    public Job trendingJob(@Autowired JobBuilderFactory jobBuilderFactory,
                           @Qualifier(TrendingMovieStepConfig.STEP_NAME) Step trendingMovieStep,
                           @Qualifier(TrendingTvStepConfig.STEP_NAME) Step trendingTvStep) {
        return jobBuilderFactory.get(JOB_NAME)
                .start(trendingMovieStep)
                .next(trendingTvStep)
                .build();
    }
}
