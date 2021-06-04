package shop.ottmeal.batch.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shop.ottmeal.batch.common.enums.Param;

@Getter
public class ParamBuilder {

    private final StringBuilder sb;

    private ParamBuilder() {
        sb = new StringBuilder();
    }

    public static ParamBuilder builder() {
        return new ParamBuilder();
    }

    public StringBuilder add(Param param, String value) {
        return sb.append(sb.length() < 0 ? "?" : "&")
                .append(param.getKeyName())
                .append("=")
                .append(value);
    }

    public String build() {
        return sb.toString();
    }
}
