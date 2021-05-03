package shop.ottmeal.batch.common.reader;

import lombok.Getter;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RestItemReader<T> implements ItemReader<T> {

    private final RestTemplate restTemplate;
    private final String url;
    private final boolean isEmpty;

    @Getter
    private List<T> responseList;
    private int index;
    private Class<T[]> clazz;
    private HttpMethod httpMethod;

    public RestItemReader() {
        this.restTemplate = null;
        this.url = null;
        this.isEmpty = true;
    }

    public RestItemReader(RestTemplate restTemplate, String url, Class<T[]> clazz, HttpMethod httpMethod) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.clazz = clazz;
        this.httpMethod = httpMethod;
        this.isEmpty = false;
    }

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (this.isEmpty) {
            return null;
        }

        if (Objects.isNull(this.responseList)) {
            this.responseList = refresh();
        }

        if (this.index >= this.responseList.size()) {
            return null;
        }

        return this.responseList.get(this.index++);
    }

    private List<T> refresh() {
        ResponseEntity<T[]> response = request();
        if (!validate(response)) {
            return Collections.emptyList();
        }
        return Arrays.asList(response.getBody());
    }

    private ResponseEntity<T[]> request() {
        return this.restTemplate.exchange(this.url, httpMethod, null, clazz);
    }

    private boolean validate(ResponseEntity<T[]> response) {
        return Objects.nonNull(response) && response.hasBody();
    }
}
