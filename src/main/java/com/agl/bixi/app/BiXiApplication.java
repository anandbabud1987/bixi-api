package com.agl.bixi.app;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bixi.repository.UserProfileRepository;

@ComponentScan({"com.agl.bixi"})
@EntityScan("com.bixi.data.domain.model.db")
@EnableJpaRepositories("com.bixi.repository")
@SpringBootApplication(scanBasePackages={"com.agl.bixi"})
@EnableAutoConfiguration
public class BiXiApplication {

	@Autowired
    DataSource dataSource;

    @Autowired
    UserProfileRepository userprofilerepo;
	public static void main(String[] args) {
		SpringApplication.run(BiXiApplication.class,args);
	}

}
