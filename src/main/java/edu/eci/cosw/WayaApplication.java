package edu.eci.cosw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("edu.eci.cosw.repository")
//@EntityScan("edu.eci.cosw.entities")
@SpringBootApplication
public class WayaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WayaApplication.class, args);
	}
}
