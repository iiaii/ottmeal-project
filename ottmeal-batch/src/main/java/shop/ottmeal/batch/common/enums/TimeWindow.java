package shop.ottmeal.batch.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TimeWindow {
    Day("/day"),
    Week("/week");

    private final String resource;
}
