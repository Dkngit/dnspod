package DNSPod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseStatus {

    private String code;
    private String message;
    private String created_at;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "ResponseStatus{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
