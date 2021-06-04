package shop.ottmeal.batch.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParamBuilder {

    private final StringBuilder sb;

    public static ParamBuilder builder() {
        return new ParamBuilder(new StringBuilder("?"));
    }

    public StringBuilder add(String key, String value) {
        sb.append(key, )
    }
}
