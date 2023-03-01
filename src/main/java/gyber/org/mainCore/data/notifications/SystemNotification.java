package gyber.org.mainCore.data.notifications;

import java.util.Date;

public class SystemNotification extends Notification{


    public SystemNotification(String from, String assignedTo, Date dateOfSend, String message) {
        super(from, assignedTo, dateOfSend, message, false);
    }

    public SystemNotification(){}
}
