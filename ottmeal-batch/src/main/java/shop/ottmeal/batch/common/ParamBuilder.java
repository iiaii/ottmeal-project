package shop.ottmeal.batch.common;

import lombok.Getter;
import shop.ottmeal.batch.common.enums.Param;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ParamBuilder {

    private final Map<Param, String> params;

    private ParamBuilder() {
        params = new HashMap<>();
    }

    public static ParamBuilder builder() {
        return new ParamBuilder();
    }

    public ParamBuilder addParam(Param param, String value) {
        params.put(param, value);
        return this;
    }

    public ParamBuilder addParam(Param param, int value) {
        params.put(param, Integer.toString(value));
        return this;
    }

    public void countUpValue(Param param) {
        try {
            int value = Integer.parseInt(params.get(param));
            params.put(param, Integer.toString(++value));
        } catch(NumberFormatException e) {
            return;
        }
    }

    public void set(Param param, String value) {
        params.put(param, value);
    }

    @Override
    public String toString() {
        return params.keySet().stream()
                .map(key -> key + "=" + params.get(key))
                .collect(Collectors.joining("&", "?", ""));
    }
}
