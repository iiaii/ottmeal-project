package shop.ottmeal.batch.common;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;

@Builder
@RequiredArgsConstructor
public class Request <T> {

    private final String url;

    @Getter
    private final Params params;

    @Getter
    private final HttpMethod httpMethod;

    @Getter
    private final Class<T> responseType;

    public String getUrl() {
        return url + params;
    }
}
