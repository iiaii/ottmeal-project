//package shop.ottmeal.batch.movie;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.JobDetailFactoryBean;
//import shop.ottmeal.batch.common.AbstractBatchConfig;
//import shop.ottmeal.batch.common.DefaultQuartzJob;
//import shop.ottmeal.batch.common.QuartzBatchCombiner;
//import shop.ottmeal.batch.common.SchedulerNameGenerator;
//
//import java.util.Objects;
//
//@Slf4j
//@Configuration
//public class LatestMovieJobConfig extends AbstractBatchConfig {
//    private static final String JOB_NAME = "fetchMovieJob";
//
//    @Value("${job.movieJob.fetch.trigger")
//    private String trigger;
//
//    @Bean("fetchMovieJobDetailFactoryBean")
//    public JobDetailFactoryBean jobDetailFactoryBean(@Qualifier(JOB_NAME) Job job) {
//        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
//
//        QuartzBatchCombiner.merge(
//                jobDetailFactory,
//                property.getGroup(),
//                DefaultQuartzJob.class,
//                job,
//                new JobParameters()
//        );
//
//        return jobDetailFactory;
//    }
//
//    @Bean("fetchMovieJobCronTriggerFactoryBean")
//    public CronTriggerFactoryBean cronTriggerFactoryBean(@Qualifier(JOB_NAME) Job job) {
//        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
//        cronTriggerFactoryBean.setJobDetail(Objects.requireNonNull(jobDetailFactoryBean(job).getObject()));
//        cronTriggerFactoryBean.setName(SchedulerNameGenerator.generateQuartzTriggerName(job.getName()));
//        cronTriggerFactoryBean.setGroup(SchedulerNameGenerator.generateQuartzTriggerGroupName());
//        cronTriggerFactoryBean.setCronExpression(trigger);
//
//        return cronTriggerFactoryBean;
//    }
//
//    @Bean(JOB_NAME)
//    public Job fetchMovieJob(@Autowired JobBuilderFactory jobBuilderFactory,
//                             @Qualifier(LatestMovieStepConfig.STEP_NAME) Step latestMovieStep
//                             ) {
//        return jobBuilderFactory.get(JOB_NAME)
//                .start(latestMovieStep)
//                .build();
//    }
//
//
//
//}
