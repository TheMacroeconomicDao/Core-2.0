package gyber.org.mainCore.notification;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
@Getter
@Setter
@Slf4j
public class InviteNotification extends Notification {


    private Boolean invitationAccepted;

    /**
     * AllArgsConstructor.
     * @param from ...
     * @param assignedTo ...
     * @param dateOfSend ...
     * @param message ...
     */
    public InviteNotification(String from, String assignedTo, Date dateOfSend, String message) {
        super(from, assignedTo, dateOfSend, message, false);
    }

    /**
     * NoArgsConstructor.
     */
    public InviteNotification() {
    }
}
