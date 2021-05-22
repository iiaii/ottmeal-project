package shop.ottmeal.batch.common;

import shop.ottmeal.batch.common.enums.MediaType;
import shop.ottmeal.batch.common.enums.TimeWindow;

public class ApiGenerator {

    private final static String TMDB_BASE_URL = "https://api.themoviedb.org/3";

    /**
     * 트렌딩 미디어 리스트 url
     *
     * - /trending/{media_type}/{time_window}
     *      - media_type : all, movie, tv, person
     *      - time_window : day, week
     * - https://developers.themoviedb.org/3/trending/get-trending
     * @param mediaType
     * @return
     */
    public static String getTrending(MediaType mediaType, TimeWindow timeWindow) {
        return TMDB_BASE_URL +
    }
}
