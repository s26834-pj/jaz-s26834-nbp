package pl.pjatk.jazs26834nbp.exception;

import org.springframework.http.HttpStatus;


public class ApiResponse {
    private HttpStatus status;
    private String message;

    public ApiResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}