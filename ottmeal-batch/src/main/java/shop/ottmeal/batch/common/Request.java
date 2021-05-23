package shop.ottmeal.batch.common;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;

@Getter
@Builder
@RequiredArgsConstructor
public class Request <T> {

    private final String url;
    private final HttpMethod httpMethod;
    private final Class<T> responseType;
}
