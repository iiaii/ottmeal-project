//package shop.ottmeal.batch.common.reader;
//
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.NonTransientResourceException;
//import org.springframework.batch.item.ParseException;
//import org.springframework.batch.item.UnexpectedInputException;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import shop.ottmeal.batch.module.movie.job.latest.dto.response.BaseResponse;
//
//import java.util.*;
//
//@Slf4j
//public class RestItemReader<T extends BaseResponse> implements ItemReader<T> {
//
//    private final RestTemplate restTemplate;
//    private final String url;
//    private final boolean isEmpty;
//
//    @Getter
//    private T response;
//    private int index;
//    private Class<T> clazz;
//    private HttpMethod httpMethod;
//
//    public RestItemReader() {
//        this.restTemplate = null;
//        this.url = null;
//        this.isEmpty = true;
//    }
//
//    public RestItemReader(RestTemplate restTemplate, String url, Class<T> clazz, HttpMethod httpMethod) {
//        this.restTemplate = restTemplate;
//        this.url = url;
//        this.clazz = clazz;
//        this.httpMethod = httpMethod;
//        this.isEmpty = false;
//    }
//
//    @Override
//    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        if (this.isEmpty) {
//            return null;
//        }
//
//        if (Objects.isNull(this.response)) {
//            this.response = refresh();
//        }
//
//        if (this.index >= this.response.getResults().size()) {
//            return null;
//        }
//
//        return this.response.getResults().get(this.index++);
//    }
//
//    private T refresh() {
//        ResponseEntity<T> response = request();
//        if (!validate(response)) {
//            return null;
//        }
//        return response.getBody();
//    }
//
//    private ResponseEntity<T> request() {
//        return this.restTemplate.exchange(this.url, httpMethod, null, clazz);
//
//    }
//
//    private boolean validate(ResponseEntity<T> response) {
//        return Objects.nonNull(response) && response.hasBody();
//    }
//}
