package gyber.org.mainCore.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
@Slf4j
public class MainController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        log.info("Method sayHello from MainController.class");

        return ResponseEntity.ok("Hello from secured endpoint");
    }

}
