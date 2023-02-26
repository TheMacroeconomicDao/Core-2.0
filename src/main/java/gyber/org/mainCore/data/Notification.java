package gyber.org.mainCore.data;

import java.util.Date;

public class Notification {

    private Long notificationId;


    // Думаю ...
    // private TypeNotification type;


    private String from;
    private String assignedTo;
    private Date dateOfSend;


    private String message;

    private Boolean isRead;


    public Notification(String from, String assignedTo, Date dateOfSend, String message, Boolean isRead) {
        this.from = from;
        this.assignedTo = assignedTo;
        this.dateOfSend = dateOfSend;
        this.message = message;
        this.isRead = isRead;
    }


    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDateOfSend() {
        return dateOfSend;
    }

    public void setDateOfSend(Date dateOfSend) {
        this.dateOfSend = dateOfSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}
