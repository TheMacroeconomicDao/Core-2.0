package gyber.org.mainCore.controller;


import gyber.org.mainCore.entity.User;
import gyber.org.mainCore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usr")
@RequiredArgsConstructor
@Slf4j
public class UserServiceController {
    private final UserRepository userRepository;


    @GetMapping("/byemail")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email) {
        log.info("Method getUserByEmail from UserServiceController.class");

        return ResponseEntity.ok().build();
    }


    @GetMapping("/byid")
    public ResponseEntity<User> getUserByID() {
        log.info("Method getUserByID from UserServiceController.class");

        return ResponseEntity.ok().build();
    }

    @GetMapping("/auth")
    public ResponseEntity<User> authoriazateUserByLoginAndPasswd(Object obj) {
        log.info("Method authoriazateUserByLoginAndPasswd from UserServiceController.class");

        return ResponseEntity.ok().build();

    }

    @PostMapping("/register")
    public ResponseEntity registerTheUser(@RequestBody User user) {
        log.info("Method registerTheUser from UserServiceController.class");

        return ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    public ResponseEntity updateTheUser(@RequestBody User user, @RequestParam("id") Long id) {
        log.info("Method updateTheUser from UserServiceController.class");

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del")
    public ResponseEntity deleteTheUser(@RequestParam Long id) {
        log.info("Method deleteTheUser from UserServiceController.class");

        /*
         Мы не будем удалять данные пользователя , мы
         просто сделаем его профиль не активным. Пользователь
         в любой момент сможет восстановить доступ к профилю
         на платформе
         */
        return ResponseEntity.ok().build();
    }


}
