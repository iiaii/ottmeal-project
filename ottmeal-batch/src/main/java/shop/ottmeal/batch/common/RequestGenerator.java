package shop.ottmeal.batch.common;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import shop.ottmeal.batch.common.enums.MediaType;
import shop.ottmeal.batch.common.enums.TimeWindow;
import shop.ottmeal.batch.module.movie.job.trending.dto.response.LatestMovieResponse;

@RequiredArgsConstructor
public class RequestGenerator {

    private final static String TMDB_BASE_URL = "https://api.themoviedb.org/3";

    /**
     * 트렌딩 미디어 리스트 Request 생성
     *
     * - GET /trending/{media_type}/{time_window}
     *      - media_type : all, movie, tv, person
     *      - time_window : day, week
     * - https://developers.themoviedb.org/3/trending/get-trending
     * @param mediaType
     * @param timeWindow
     * @return
     */
    public static Request<LatestMovieResponse> getTrendingRequest(MediaType mediaType, TimeWindow timeWindow) {
        return Request.<LatestMovieResponse>builder()
                .url(TMDB_BASE_URL + mediaType.getResource() + timeWindow.getResource())
                .httpMethod(HttpMethod.GET)
                .responseType(LatestMovieResponse.class)
                .build();
    }
}
