package gyber.org.mainCore.notification;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;
import java.util.Queue;


@Component
public class NotificationCenter {

    // private NotificationRepository repository;


    private Queue<Notification> notificationQueue;

    private Notification localNotification;

    /**
     * Не знаю за что отвечает метод(Aomisha).
     */
    @PostConstruct
    public void init() {
        this.notificationQueue = new PriorityQueue<>();

    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @param notification ...
     * @return ...
     */
    public NotificationCenter setTheNotification(Notification notification) {
        this.localNotification = notification;
        return this;
    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @return ...
     */
    public NotificationCenter installFlags() {
        return this;

    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @return ...
     */
    public NotificationCenter isSystemMessage() {
        return this;
    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @return ...
     */
    public NotificationCenter checkTheNotificationData() {
        // Проверка отправителя , получателя , данных ,
        return this;
    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @return ...
     */
    public NotificationCenter addToRegisterNotifications() {
        // логика базы данных. Занисение предварительного
        // увидомления в регистр
        return this;
    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @return ...
     */
    public NotificationCenter addTheQueue() {
        // Добовление в очередь предварительного увидомления
        // Увидомления которое не было отослоно
        return this;
    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     */
    public void processTheNotification() {
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
