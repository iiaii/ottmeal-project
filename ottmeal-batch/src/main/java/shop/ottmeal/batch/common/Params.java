package shop.ottmeal.batch.common;

import shop.ottmeal.batch.enums.Param;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Params {

    private final Map<Param, String> params;

    private Params() {
        params = new HashMap<>();
    }

    public static Params builder() {
        return new Params();
    }

    public String getParam(Param param) {
        return params.get(param);
    }

    public Params addParam(Param param, String value) {
        params.put(param, value);
        return this;
    }

    public Params addParam(Param param, int value) {
        params.put(param, Integer.toString(value));
        return this;
    }

    public void addValueIfNumber(Param param) {
        try {
            int value = Integer.parseInt(params.get(param));
            params.put(param, Integer.toString(++value));
        } catch(NumberFormatException e) {
            return;
        }
    }

    public void resetValueIfNumber(Param param) {
        try {
            int value = Integer.parseInt(params.get(param));
            params.put(param, Integer.toString(0));
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
                .map(key -> key.getKeyName() + "=" + params.get(key))
                .collect(Collectors.joining("&", "?", ""));
    }
}
