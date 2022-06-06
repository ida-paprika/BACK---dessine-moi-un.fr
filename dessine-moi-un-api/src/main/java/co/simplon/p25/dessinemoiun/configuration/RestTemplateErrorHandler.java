package co.simplon.p25.dessinemoiun.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

import org.apache.http.impl.io.EmptyInputStream;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestTemplateErrorHandler implements ResponseErrorHandler {

    private final ObjectMapper mapper; // Jackson JSON (de)serializer

    public RestTemplateErrorHandler(ObjectMapper mapper) {
	Objects.requireNonNull(mapper, "mapper cannot be null");
	this.mapper = mapper;
    }

    // Check if external API error is 400 + or 500 +
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
	Series series = response.getStatusCode().series();
	return series.equals(Series.CLIENT_ERROR) // 400 +
		|| series.equals(Series.SERVER_ERROR); // 500 +
    }

    // Throws RestTemplateException to be handled by ControllerAdvice
    @SuppressWarnings("unchecked")
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
	InputStream bodyAsStream = response.getBody();
	Map<String, Object> body = null;
	if (!(bodyAsStream instanceof EmptyInputStream)) { // Only if body
	    body = mapper.readValue(bodyAsStream, Map.class);
	}
	throw new RestTemplateException(response.getStatusCode(), body);
    }
}
