package co.simplon.p25.dessinemoiun.configuration;

import java.util.Map;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class RestTemplateException extends RuntimeException {

    private HttpStatus status;

    private Map<String, Object> body;

    public RestTemplateException(HttpStatus status, Map<String, Object> body) {
	this.status = status;
	this.body = body;
    }

    public HttpStatus getStatus() {
	return status;
    }

    public Map<String, Object> getBody() {
	return body;
    }
}
