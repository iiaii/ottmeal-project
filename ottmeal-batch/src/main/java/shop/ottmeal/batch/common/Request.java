package shop.ottmeal.batch.common;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Builder
@RequiredArgsConstructor
public class Request <T> {

    private final String url;
    private final Map<String, String> params;
    private final HttpMethod httpMethod;
    private final Class<T> responseType;

    public Request(String url, Map<String, String> params, HttpMethod httpMethod, Class<T> responseType) {
        this.url = url;
        this.params = params;
        this.httpMethod = httpMethod;
        this.responseType = responseType;
    }
}
