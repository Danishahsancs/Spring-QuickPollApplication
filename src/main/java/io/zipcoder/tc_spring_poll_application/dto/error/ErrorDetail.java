package io.zipcoder.tc_spring_poll_application.dto.error;

public class ErrorDetail {

    private String title;           // e.g., "Resource Not Found"
    private int status;             // e.g., 404
    private String detail;          // e.g., "Poll with id 5 not found"
    private long timeStamp;         // e.g., System.currentTimeMillis()
    private String developerMessage; // e.g., exception class name or stack trace

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
