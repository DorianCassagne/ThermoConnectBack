package me.dcal.thermoconnect;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import me.dcal.thermoconnect.service.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ThermoconnectApplication {

	public static void main(String[] args) {
			
		SpringApplication.run(ThermoconnectApplication.class, args);
	}

}
