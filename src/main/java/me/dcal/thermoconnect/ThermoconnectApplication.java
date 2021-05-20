package me.dcal.thermoconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import me.dcal.thermoconnect.file.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ThermoconnectApplication {

	public static void main(String[] args) {
    	System.out.println("pipi");
		SpringApplication.run(ThermoconnectApplication.class, args);
	}

}
