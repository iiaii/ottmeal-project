package shop.ottmeal.batch.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Getter @Setter
public abstract class AbstractBatchConfig {

    @Autowired
    protected JobBuilderFactory jobBuilderFactory;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    @Autowired
    protected JobRegistry jobRegistry;

    @Autowired
    protected JobLauncher jobLauncher;

    @Autowired
    protected JobLocator jobLocator;

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    protected SchedulerAutoConfigProperty property;

}
