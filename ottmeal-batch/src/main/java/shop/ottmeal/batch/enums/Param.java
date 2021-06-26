package shop.ottmeal.batch.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Param {
    API_KEY("api_key"),
    LANGUAGE("language"),
    PAGE("page");

    private final String keyName;
}
