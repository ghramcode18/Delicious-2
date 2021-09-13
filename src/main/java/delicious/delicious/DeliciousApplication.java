package delicious.delicious;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @ComponentScan("org.The.clousure.repositories")//to scan repository files
// @EntityScan("org.The.clousure.entities")
// @EnableJpaRepositories("org.The.clousure.repositories")
public class DeliciousApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliciousApplication.class, args);
	}

}
