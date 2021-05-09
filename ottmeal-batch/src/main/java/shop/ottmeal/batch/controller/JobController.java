package shop.ottmeal.batch.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.ottmeal.batch.module.movie.job.latest.LatestMovieJobConfig;

@Slf4j
@Controller
public class JobController {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Autowired
    public JobController(JobLauncher jobLauncher, @Qualifier(LatestMovieJobConfig.JOB_NAME) Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @GetMapping("/latestMovieJob")
    public String latestMovieJob(@RequestParam("test") String test) {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("input.test", test)
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch(Exception e) {
            log.info(e.getMessage());
        }

        return "최신 영화 가져오기 작업 완료";
    }
}
