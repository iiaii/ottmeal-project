package shop.ottmeal.batch.common;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import shop.ottmeal.batch.enums.MediaType;
import shop.ottmeal.batch.enums.Param;
import shop.ottmeal.batch.enums.TimeWindow;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResponse;
import shop.ottmeal.batch.module.trending.job.movie.dto.MovieDetailResponse;
import shop.ottmeal.batch.module.trending.job.tv.dto.response.TvDetailResponse;

@RequiredArgsConstructor
public class RequestGenerator {

    private final static String TMDB_BASE_URL = "https://api.themoviedb.org/3";

    private final static String apiKey = "0b1fe3786795a257dd0648d67445af97";

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
    public static Request<TrendingResponse> getTrendingRequest(MediaType mediaType, TimeWindow timeWindow) {
        return Request.<TrendingResponse>builder()
                .url(TMDB_BASE_URL + "/trending" + mediaType.getResource() + timeWindow.getResource())
                .params(Params.builder()
                        .addParam(Param.API_KEY, apiKey)
                        .addParam(Param.PAGE, 1))
                .httpMethod(HttpMethod.GET)
                .responseType(TrendingResponse.class)
                .build();
    }

    /**
     * Movie 디테일 Request 생성
     *
     * @param mediaId
     * @return
     */
    public static Request<MovieDetailResponse> getMovieDetailRequest(Long mediaId) {
        return getMediaDetailRequest(MediaType.Movie, mediaId, MovieDetailResponse.class);
    }

    /**
     * Tv 디테일 Request 생성
     *
     * @param mediaId
     * @return
     */
    public static Request<TvDetailResponse> getTvDetailRequest(Long mediaId) {
        return getMediaDetailRequest(MediaType.Tv, mediaId, TvDetailResponse.class);
    }

    /**
     * Media (Movie, Tv, People) 디테일 Request 생성
     *
     * - GET /{media_type}/{media_id}
     *      - media_type : movie, tv, person
     *      - media_id : media id
     *
     * @param mediaType
     * @param mediaId
     * @return
     */
    private static <T> Request<T> getMediaDetailRequest(MediaType mediaType, Long mediaId, Class<T> responseType) {
        return Request.<T>builder()
                .url(TMDB_BASE_URL + mediaType.getResource() + "/" + mediaId + apiKey + "&language=ko")
                .params(Params.builder().addParam(Param.API_KEY, apiKey))
                .httpMethod(HttpMethod.GET)
                .responseType(responseType)
                .build();
    }
}
