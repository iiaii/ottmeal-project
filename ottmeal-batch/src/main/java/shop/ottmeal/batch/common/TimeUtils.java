package shop.ottmeal.batch.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TimeUtils {

    public static LocalDateTime convertFromYyyyMmDd(String date) {
        if (Objects.isNull(date) || date.isEmpty()) {
            return null;
        }
        return LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ISO_DATE), LocalTime.MIDNIGHT);
    }
}
