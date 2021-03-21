package shop.ottmeal.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.ottmeal.api.service.movie.MovieService;
import shop.ottmeal.api.service.movie.dto.MovieSimpleDto;
import shop.ottmeal.common.constant.EndPoint;
import shop.ottmeal.common.constant.path.MoviePath;

import java.time.LocalDateTime;

@Slf4j
@RequestMapping(EndPoint.MOVIE)
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(MoviePath.MOVIE_SAVE)
    public Long saveMovie() {
        return movieService.saveMovie(MovieSimpleDto.builder()
                .title("TEST")
                .adult(false)
                .build()
        );
    }

    @GetMapping(MoviePath.MOVIE_GET)
    public MovieSimpleDto getMovie(final @PathVariable Long idx) {
        return movieService.getMovie(idx);
    }
}
