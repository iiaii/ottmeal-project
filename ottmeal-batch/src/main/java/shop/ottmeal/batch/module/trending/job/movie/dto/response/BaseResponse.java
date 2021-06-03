package shop.ottmeal.batch.module.trending.job.movie.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class BaseResponse <T> {

    private List<T> results;
}
