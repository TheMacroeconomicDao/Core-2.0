package gyber.org.mainCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MainCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainCoreApplication.class, args);
	}

}
