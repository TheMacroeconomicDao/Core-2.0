package gyber.org.mainCore.data.entities;


import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserFriendId implements Serializable {

    private Integer userId;
    private Integer friendId;





    public UserFriendId(Integer user_id , Integer friend_Id) {
        this.userId = user_id;
        this.friendId = friend_Id;

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }
}
