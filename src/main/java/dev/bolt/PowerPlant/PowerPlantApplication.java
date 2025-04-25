package dev.bolt.PowerPlant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PowerPlantApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerPlantApplication.class, args);
	}

}
