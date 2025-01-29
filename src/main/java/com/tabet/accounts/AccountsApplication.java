package com.tabet.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title="Accounts microservice REST API documentation",
				description= "Bank Accounts microservice REST API DOCUMENTATION",
				version="v1",
				contact=@Contact(
						name= "TABET Alaaddine",
						email= "alta.tabet@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Accounts microservice REST API documentation",
		        url = "test.html"
)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
