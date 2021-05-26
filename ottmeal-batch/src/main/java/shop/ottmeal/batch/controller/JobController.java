package shop.ottmeal.batch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.ottmeal.batch.module.movie.job.trending.TrendingJobConfig;

@Slf4j
@RestController
public class JobController {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Autowired
    public JobController(JobLauncher jobLauncher,
                         @Qualifier(TrendingJobConfig.JOB_NAME) Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @GetMapping("/trendingJob")
    public String latestMovieJob(@RequestParam("version") String version) {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("version", version)
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch(Exception e) {
            log.info(e.getMessage());
        }

        return "최신 영화 가져오기 작업 완료";
    }
}
