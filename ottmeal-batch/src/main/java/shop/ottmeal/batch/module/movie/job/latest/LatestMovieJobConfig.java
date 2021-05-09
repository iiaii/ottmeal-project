package shop.ottmeal.batch.module.movie.job.latest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import shop.ottmeal.batch.module.movie.job.latest.step.LatestMovieJobStepConfig;

import java.util.Objects;

@Slf4j
@Configuration
public class LatestMovieJobConfig {
    private static final String JOB_NAME = "latestMovieJob";

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
    public Job latestMovieJob(@Autowired JobBuilderFactory jobBuilderFactory,
                              @Qualifier(LatestMovieJobStepConfig.STEP_NAME) Step latestMovieStep) {
        return jobBuilderFactory.get(JOB_NAME)
                .start(latestMovieStep)
                .build();
    }
}
