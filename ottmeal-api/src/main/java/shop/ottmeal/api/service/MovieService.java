package shop.ottmeal.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shop.ottmeal.api.domain.Movie;
import shop.ottmeal.api.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getPopularMovies(Pageable pageable) {

    }
}
