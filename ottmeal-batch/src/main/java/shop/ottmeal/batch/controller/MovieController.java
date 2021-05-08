package shop.ottmeal.batch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import shop.ottmeal.batch.service.MovieService;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


}
