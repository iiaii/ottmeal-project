package shop.ottmeal.api.service.movie.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import shop.ottmeal.api.domain.Movie;

import java.time.LocalDateTime;

@Getter
public class MovieSimpleDto {

    private String title;

    private boolean adult;

    private LocalDateTime createdTime;

    @Builder
    public MovieSimpleDto(String title, boolean adult, LocalDateTime createdTime) {
        this.title = title;
        this.adult = adult;
        this.createdTime = createdTime;
    }

    public Movie toEntity() {
        return Movie.builder()
                .title(this.title)
                .adult(this.adult)
                .director("??")
                .build();
    }
}


