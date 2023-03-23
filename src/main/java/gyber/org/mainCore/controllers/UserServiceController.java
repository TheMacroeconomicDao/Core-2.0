package gyber.org.mainCore.controllers;


import gyber.org.mainCore.data.entities.User;
import gyber.org.mainCore.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usr")
public class UserServiceController {



    @Autowired
    public UserRepository userRepository;




    @GetMapping("/byemail")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/bynick")
    public ResponseEntity<User> getUserByNickName(@RequestParam("nick") String nickName){
        // ...

        return ResponseEntity.ok().build();

    }



    @GetMapping("/byid")
    public ResponseEntity<User> getUserByID(@RequestParam("usrid") Long id){
        try{

            User local = this.userRepository.findById(id).orElseThrow();


            return local == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(local);




        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/auth")
    public ResponseEntity<User> authoriazateUserByLoginAndPasswd(Object obj){
        return ResponseEntity.ok().build();

    }

    @PostMapping("/register")
    public ResponseEntity registerTheUser(@RequestBody  User user){

        return ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    public ResponseEntity updateTheUser(@RequestBody User user , @RequestParam("id") Long id){

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deactivate")
    public ResponseEntity deactivateUserProfile(@RequestParam("id") Long id){

        /*
         Мы не будем удалять данные пользователя , мы
         просто сделаем его профиль не активным. Пользователь
         в любой момент сможет восстановить доступ к профилю
         на платформе
         */
        return ResponseEntity.ok().build();
    }






}
