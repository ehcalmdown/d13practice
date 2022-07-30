package sg.nus.iss.workshop13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop13Application implements ApplicationRunner{

	@Autowired
	

	public static void main(String[] args) {
		SpringApplication.run(Workshop13Application.class, args);
	}

}
