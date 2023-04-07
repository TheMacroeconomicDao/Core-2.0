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
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MODERATOR"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User("vlasenko12ava@gmail.com", "Aleksandr", "Aomisha", "Vlasenko", "123", new ArrayList<>()));
			userService.saveUser(new User("grebnev@gmail.com", "Danila", "muhamad", "Grebnev", "123", new ArrayList<>()));
			userService.saveUser(new User("carring@mail.ru", "Aleksandr", "carring", "Smirnov", "123", new ArrayList<>()));

			userService.addRoleToUser("Aomisha", "ROLE_ADMIN");
			userService.addRoleToUser("vlasenko12ava@gmail.com", "ROLE_MODERATOR");
			userService.addRoleToUser("grebnev@gmail.com", "ROLE_MODERATOR");
			userService.addRoleToUser("carring", "ROLE_USER");
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
