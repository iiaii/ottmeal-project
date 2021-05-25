package shop.ottmeal.batch.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
public enum MediaType {
    Movie("/movie"),
    Tv("/tv"),
    Person("/person");

    private final String resource;
}
