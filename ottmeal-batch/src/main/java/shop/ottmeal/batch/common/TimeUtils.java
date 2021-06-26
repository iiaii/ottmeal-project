package shop.ottmeal.batch.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    public static LocalDateTime convertFromYyyyMmDd(String date) {
        if (date.isEmpty()) {
            return null;
        }
        return LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ISO_DATE), LocalTime.MIDNIGHT);
    }
}
