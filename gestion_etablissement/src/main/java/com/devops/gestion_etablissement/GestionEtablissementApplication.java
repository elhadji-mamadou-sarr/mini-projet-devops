package com.devops.gestion_etablissement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GestionEtablissementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEtablissementApplication.class, args);
	}

}
