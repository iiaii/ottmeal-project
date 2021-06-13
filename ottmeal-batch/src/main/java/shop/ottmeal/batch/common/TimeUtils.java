package shop.ottmeal.batch.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    public static LocalDateTime convertFromYyyyMmDd(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
