package gyber.org.mainCore.data.entities;

import jakarta.persistence.Id;

public class UsersFriends {


    @Id
    Long pair_ID;



    User user_id;
    User friend_id;



}
