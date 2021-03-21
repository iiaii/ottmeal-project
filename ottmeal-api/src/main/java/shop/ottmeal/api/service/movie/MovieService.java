package shop.ottmeal.api.service.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shop.ottmeal.api.domain.Movie;
import shop.ottmeal.api.repository.MovieRepository;
import shop.ottmeal.api.service.movie.dto.MovieSimpleDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Long saveMovie(MovieSimpleDto movieSimpleDto) {
        return movieRepository.save(movieSimpleDto.toEntity()).getIdx();
    }

    public MovieSimpleDto getMovie(Long idx) {
        Movie movie = movieRepository.getOne(idx);

        return MovieSimpleDto.builder()
                .title(movie.getTitle())
                .adult(movie.isAdult())
                .createdTime(movie.getCreatedTime())
                .build();
    }

}
