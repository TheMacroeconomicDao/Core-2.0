package gyber.org.mainCore.notification;

import java.util.Date;

public class SystemNotification extends Notification {

    /**
     * AllArgsConstructor.
     * @param from ...
     * @param assignedTo ...
     * @param dateOfSend ...
     * @param message ...
     */
    public SystemNotification(String from, String assignedTo, Date dateOfSend, String message) {
        super(from, assignedTo, dateOfSend, message, false);
    }

    /**
     * NoArgsConstructor.
     */
    public SystemNotification() {
    }
}
