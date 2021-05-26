package shop.ottmeal.batch.module.movie.job.trending.step.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Slf4j
public class TrendingItemWriter <T> implements ItemWriter<T> {

    private JpaRepository repository;

    public TrendingItemWriter(JpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        items.stream()
                .forEach(repository::save);

    }
}
