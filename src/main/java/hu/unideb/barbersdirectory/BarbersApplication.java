package hu.unideb.barbersdirectory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarbersApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BarbersApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}
}
