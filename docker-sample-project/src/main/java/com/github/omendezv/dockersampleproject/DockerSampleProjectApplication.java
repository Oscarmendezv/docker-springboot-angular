package com.github.omendezv.dockersampleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DockerSampleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerSampleProjectApplication.class, args);
	}

}
