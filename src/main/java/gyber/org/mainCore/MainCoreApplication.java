package gyber.org.mainCore;

import gyber.org.mainCore.data.entities.Role;
import gyber.org.mainCore.data.entities.User;
import gyber.org.mainCore.data.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "gyber.org.mainCore.data.repository")
@EntityScan(basePackages = "gyber.org.mainCore.data.entities")
public class MainCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainCoreApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
