package gyber.org.mainCore.data.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "users_friends")
public class UsersFriends {


    @EmbeddedId
    private UserFriendId userFriendId;


    private Boolean accepted;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    @Column(name = "accepted_date")
    private LocalDateTime acceptedDate;


    public UsersFriends(User user, User friend) {
        this.userFriendId = new UserFriendId(user.getId(), friend.getId());
    }

    public UserFriendId getUserFriendId() {
        return userFriendId;
    }

    public void setUserFriendId(UserFriendId userFriendId) {
        this.userFriendId = userFriendId;
    }


    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDateTime getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(LocalDateTime acceptedDate) {
        this.acceptedDate = acceptedDate;
    }
}
