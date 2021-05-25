package io.swagger.model.DTO;

public class ExceptionDTO {
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ExceptionDTO(String reason) {
        this.reason = reason;
    }
}
