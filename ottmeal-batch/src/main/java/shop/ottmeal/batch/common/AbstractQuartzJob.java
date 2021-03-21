package shop.ottmeal.batch.common;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.Properties;
import java.util.UUID;

import static shop.ottmeal.batch.common.QuartzBatchCombiner.*;

@Slf4j
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public abstract class AbstractQuartzJob implements Job {

    @Autowired
    protected JobLauncher jobLauncher;

    @Autowired
    protected JobLocator jobLocator;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            // JobDataMap에 있는 잡 이름과 잡 파라미터 실행
            JobDataMap jobDataMap = context.getMergedJobDataMap();
            String batchJobName = jobDataMap.getString(BATCH_JOB_NAME_KEY);
            JobParameters jobParameters = (JobParameters) jobDataMap.get(BATCH_JOB_PARAMETER_NAME_KEY);

            // 위임 및 실행
            org.springframework.batch.core.Job job = doExecute(context);
            jobParameters = build(jobParameters);

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            log.info("quartz start{"+ batchJobName + "} ----- {} :" + context.getTrigger().getJobKey() + ":" + batchJobName);
            jobLauncher.run(job, build(jobParameters));
            stopWatch.stop();
            log.info("quartz end{" + batchJobName + "} ----- {" + stopWatch.getTotalTimeMillis() + "}");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Spring batch는 job instance와 job parameter가 job execution pk 그래서 매번 잡을 실행 할 때 마다 랜덤하게 키를 발급
     *
     * @param parameters
     * @return
     */
    private JobParameters build(JobParameters parameters) {
        JobParametersBuilder parametersBuilder = new JobParametersBuilder();
        UUID uuid = UUID.randomUUID();

        // Job은 JobParameter로 실행을 구분하기 때문에 매 실행 시 값을 할당하게 한다
        parametersBuilder.addString(BATCH_JOB_PARAMETER_IDENTITY_KEY, uuid.toString());

        if (parameters == null) {
            return parametersBuilder.toJobParameters();
        }

        // parameterBuidler
        Properties properties = parameters.toProperties();
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            parametersBuilder.addString(key, value);
        }

        return parametersBuilder.toJobParameters();
    }

    /**
     * 상속 받은 자식 클래스에서 잡 실행 비즈니스로직을 구현하게 강제함
     *
     * @throws JobExecutionException the job execution exception
     */
    public abstract org.springframework.batch.core.Job doExecute(JobExecutionContext context) throws Exception;

}
