package shop.ottmeal.batch.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter @Setter
public class SchedulerAutoConfigProperty {

    String version;
    String name;
    String group;
    String defaultTrigger;
    SchedulerAutoConfigProperty.Database database;
    SchedulerAutoConfigProperty.Batch batch;
    Map<String, String> quartz = new HashMap<>();

    @NoArgsConstructor
    @Getter @Setter
    public static class Database {
        Integer maxPoolSize;
        Map<String, String> trigger;
    }

    @NoArgsConstructor
    @Getter @Setter
    public class Batch {
        String driver;
        String jdbcUrl;
        String user;
        String password;
        String testQuery;
        Integer maxPoolSize;
        Long timeout;
    }
}
