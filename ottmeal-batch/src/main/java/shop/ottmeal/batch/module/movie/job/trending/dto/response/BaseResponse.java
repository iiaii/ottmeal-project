package shop.ottmeal.batch.module.movie.job.trending.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class BaseResponse <T> {

    private List<T> results;
}
