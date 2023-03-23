package gyber.org.mainCore.data.notifications;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;
import java.util.Queue;


@Component
public class NotificationCenter {

    // private NotificationRepository repository;


    private Queue<Notification>notificationQueue;

    private Notification localNotification;




    @PostConstruct
    public void init(){
        this.notificationQueue = new PriorityQueue<>();
        
    }


    public NotificationCenter setTheNotification(Notification notification){
       this.localNotification = notification;
       return this;
    }


    public NotificationCenter installFlags(){
        return this;

    }


    public NotificationCenter isSystemMessage(){
        return this;
    }

    public NotificationCenter checkTheNotificationData(){
        // Проверка отправителя , получателя , данных ,
        return this;
    }

    public NotificationCenter addToRegisterNotifications(){
        // логика базы данных. Занисение предварительного
        // увидомления в регистр
        return this;
    }

    public NotificationCenter addTheQueue(){
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
