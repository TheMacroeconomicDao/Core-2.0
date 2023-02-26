package gyber.org.mainCore.managers;

import gyber.org.mainCore.data.Notification;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;
import java.util.Queue;


@Component
public class NotificationManagerCenter {

    // private NotificationRepository repository;


    private Queue<Notification>notificationQueue;

    private Notification localNotification;




    @PostConstruct
    public void init(){
        this.notificationQueue = new PriorityQueue<>();
        
    }


    public NotificationManagerCenter setTheNotification(Notification notification){
       this.localNotification = notification;
       return this;
    }


    public NotificationManagerCenter installFlags(){
        return this;

    }


    public NotificationManagerCenter isSystemMessage(){
        return this;
    }

    public NotificationManagerCenter checkTheNotificationData(){
        // Проверка отправителя , получателя , данных ,
        return this;
    }

    public NotificationManagerCenter addToRegisterNotifications(){
        // логика базы данных. Занисение предварительного
        // увидомления в регистр
        return this;
    }

    public NotificationManagerCenter addTheQueue(){
        // Добовление в очередь предварительного увидомления
        // Увидомления которое не было отослоно
        return this;
    }

    public void processTheNotification(){
        // Обработка увидомления. Выжедание очереди выполнения
        // увидомления. Посл того как увидомление будет обработано
        // установить влаг isRead = true и обновить данные в БД ,
        // также удалить из очереди увидомление

        // sendTheNotification()
    }

//    @Scheduled
//    private void sendTheNotification(){
//
//    }










    //  ...
}
