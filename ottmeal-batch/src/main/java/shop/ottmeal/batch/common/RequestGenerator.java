package shop.ottmeal.batch.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import shop.ottmeal.batch.enums.MediaType;
import shop.ottmeal.batch.enums.Param;
import shop.ottmeal.batch.enums.TimeWindow;
import shop.ottmeal.batch.module.trending.job.common.dto.TrendingResponse;
import shop.ottmeal.batch.module.trending.job.movie.dto.MovieDetailResponse;
import shop.ottmeal.batch.module.trending.job.tv.dto.response.TvDetailResponse;

@Configuration
@RequiredArgsConstructor
public class RequestGenerator {

    private final TmdbConfig tmdbConfig;

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
    public Request<TrendingResponse> getTrendingRequest(MediaType mediaType, TimeWindow timeWindow) {
        return Request.<TrendingResponse>builder()
                .url(tmdbConfig.getBaseUrl() + "/trending" + mediaType.getResource() + timeWindow.getResource())
                .params(Params.builder()
                        .addParam(Param.API_KEY, tmdbConfig.getApiKey())
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
    public Request<MovieDetailResponse> getMovieDetailRequest(Long mediaId) {
        return getMediaDetailRequest(MediaType.Movie, mediaId, MovieDetailResponse.class);
    }

    /**
     * Tv 디테일 Request 생성
     *
     * @param mediaId
     * @return
     */
    public Request<TvDetailResponse> getTvDetailRequest(Long mediaId) {
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
    private <T> Request<T> getMediaDetailRequest(MediaType mediaType, Long mediaId, Class<T> responseType) {
        return Request.<T>builder()
                .url(tmdbConfig.getBaseUrl() + mediaType.getResource() + "/" + mediaId)
                .params(Params.builder()
                        .addParam(Param.API_KEY, tmdbConfig.getApiKey())
                        .addParam(Param.LANGUAGE, "ko"))
                .httpMethod(HttpMethod.GET)
                .responseType(responseType)
                .build();
    }
}
