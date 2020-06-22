package pl.rafalab.rozkladeobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config.properties")
public class RozkladeoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RozkladeoBackendApplication.class, args);
	}

}
