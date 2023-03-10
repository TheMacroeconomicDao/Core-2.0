package gyber.org.mainCore.data.notifications;

import gyber.org.mainCore.notifications.Notification;

import java.util.Date;

public class InviteNotification extends Notification {


    private Boolean invitationAccepted;


    public InviteNotification(String from, String assignedTo, Date dateOfSend, String message) {
        super(from, assignedTo, dateOfSend, message, false);
    }

    public InviteNotification(){}

    public Boolean getInvitationAccepted() {
        return invitationAccepted;
    }

    public void setInvitationAccepted(Boolean invitationAccepted) {
        this.invitationAccepted = invitationAccepted;
    }
}
