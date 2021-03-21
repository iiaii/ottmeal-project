package shop.ottmeal.batch.common;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SchedulerNameGenerator {
    static final String DELIMITER_TOKEN = "-";
    static final String JOB_NAME_POSTFIX = "job";
    static final String JOB_GROUP_NAME_PREFIX = "ottmeal";
    static final String JOB_GROUP_NAME_POSTFIX = "jobGroup";
    static final String TRIGGER_NAME_POSTFIX = "trigger";
    static final String TRIGGER_GROUP_NAME_POSTFIX = "triggerGroup";

    public static String generateQuartzSchedulerName(String schedulerName, String schedulerVersion) {
        return schedulerName + "-" + schedulerVersion;
    }

    public static String generateQuartzJobName(String quartzJobName) {
        return quartzJobName + "-" + "job";
    }

    public static String generateQuartzJobGroupName() {
        return "ottmeal-jobGroup";
    }

    public static String generateQuartzTriggerName(String triggerName) {
        return triggerName + "-" + "trigger";
    }

    public static String generateQuartzTriggerGroupName() {
        return "ottmeal-triggerGroup";
    }
}
