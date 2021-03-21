package shop.ottmeal.batch.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;

@AllArgsConstructor
@Getter @Setter
public class JobDetailCronTrigger {
    JobDetail jobDetail;
    CronTrigger trigger;
}
