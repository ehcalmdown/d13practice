package sg.nus.iss.workshop13;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.nus.iss.workshop13.services.DatabaseService;

@SpringBootApplication
public class Workshop13Application implements ApplicationRunner {

	@Autowired
	DatabaseService dbSvc;

	public static void main(String[] args) {
		SpringApplication.run(Workshop13Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			dbSvc.setDataDir(new File(dataDir));

			if (!dbSvc.dataDirValidity()) {
				System.err.printf("%s does not exist, is not a directory or not writable.", dataDir);
				System.exit(-1);
			}

			System.out.printf("Using %s as data directory\n", dataDir);
		}else {
			dbSvc.setDataDir(new File("./data"));
		}
	}

}
