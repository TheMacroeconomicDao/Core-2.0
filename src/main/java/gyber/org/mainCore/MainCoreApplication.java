package gyber.org.mainCore;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
@EnableJpaRepositories(basePackages = "gyber.org.mainCore.repository")
@EntityScan(basePackages = "gyber.org.mainCore.entity")
public class MainCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainCoreApplication.class, args);
	}

	/**
	 * Получение encoder пароля.
	 * @return encoder пароля
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
