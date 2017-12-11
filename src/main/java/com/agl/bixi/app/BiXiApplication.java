package com.agl.bixi.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.agl.bixi"})
public class BiXiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiXiApplication.class,args);
	}

}
