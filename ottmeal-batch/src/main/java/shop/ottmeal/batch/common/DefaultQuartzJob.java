package shop.ottmeal.batch.common;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.batch.core.Job;

import static shop.ottmeal.batch.common.QuartzBatchCombiner.BATCH_JOB_NAME_KEY;

@DisallowConcurrentExecution
public class DefaultQuartzJob extends AbstractQuartzJob {

    /**
     * Quartz Job으로 들어온 Parameter를 Spring Batch Parameter로 변환하여 Batch Job 실행
     *
     * @param context quartz execution context
     * @throws org.quartz.JobExecutionException
     */
    @Override
    public Job doExecute(JobExecutionContext context) throws Exception {
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String batchJobName = jobDataMap.getString(BATCH_JOB_NAME_KEY);

        return jobLocator.getJob(batchJobName);
    }
}
