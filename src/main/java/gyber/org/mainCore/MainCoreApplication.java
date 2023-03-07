package gyber.org.mainCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "gyber.org.mainCore.data.repository")
@EntityScan(basePackages = "gyber.org.mainCore.data.entities")
public class MainCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainCoreApplication.class, args);
	}

}
