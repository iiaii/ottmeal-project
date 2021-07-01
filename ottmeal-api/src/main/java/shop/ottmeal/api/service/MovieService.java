package shop.ottmeal.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ottmeal.api.repository.MovieRepository;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;


}
