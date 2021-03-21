package shop.ottmeal.batch.common;

import lombok.NoArgsConstructor;
import org.quartz.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NoArgsConstructor
public class QuartzBatchCombiner {

    public static final String BATCH_JOB_NAME_KEY = "batchJob";
    public static final String BATCH_JOB_PARAMETER_NAME_KEY = "batchJobParameter";
    public static final String BATCH_JOB_PARAMETER_IDENTITY_KEY = "batchJobIdentity";

    public static final void merge(JobDetailFactoryBean jobDetailFactoryBean, String jobGroupName, Class quartzJobClass, Job batchJob, JobParameters parameters) {
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setJobClass(quartzJobClass);
        jobDetailFactoryBean.setName(batchJob.getName());
        jobDetailFactoryBean.setGroup(jobGroupName);

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(BATCH_JOB_NAME_KEY, batchJob.getName());
        jobDataMap.put(BATCH_JOB_PARAMETER_NAME_KEY, parameters);
        jobDetailFactoryBean.setJobDataMap(jobDataMap);
    }

    public static final List<JobDetailCronTrigger> merge(List<String> jobNames, String cronExpression, Class quartzClass, JobParameters jobParameters) {
        List<JobDetailCronTrigger> jobDetailCronTriggers = new ArrayList<>();
        Iterator var5 = jobNames.iterator();

        while (var5.hasNext()) {
            String jobName = (String) var5.next();
            if (quartzClass == null) {
                quartzClass = DefaultQuartzJob.class;
            }

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put(BATCH_JOB_NAME_KEY, jobName);
            jobDataMap.put(BATCH_JOB_PARAMETER_NAME_KEY, jobParameters);
            JobDetail job = JobBuilder.newJob(quartzClass).withIdentity(
                    SchedulerNameGenerator.generateQuartzJobName(jobName),
                    SchedulerNameGenerator.generateQuartzJobGroupName()
            )
                    .requestRecovery(true)
                    .storeDurably(true)
                    .setJobData(jobDataMap)
                    .build();
            CronTrigger trigger = (CronTrigger) TriggerBuilder
                    .newTrigger()
                    .forJob(job)
                    .withIdentity(
                            SchedulerNameGenerator.generateQuartzTriggerName(jobName),
                            SchedulerNameGenerator.generateQuartzTriggerGroupName()
                    )
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                    .build();
            jobDetailCronTriggers.add(new JobDetailCronTrigger(job, trigger));
        }

        return jobDetailCronTriggers;
    }
}
