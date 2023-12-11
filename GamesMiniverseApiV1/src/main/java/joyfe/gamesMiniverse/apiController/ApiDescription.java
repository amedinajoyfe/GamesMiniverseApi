package joyfe.gamesMiniverse.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class ApiDescription {
	@Value("${prod-url}")
	private String prodUrl;

	@Bean
	public OpenAPI myOpenAPI() {
		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription("Producción");

		Contact contacto = new Contact().name("Games Miniverse")
				.email("alejandro.medina.galan@alumnojoyfe.iepgroup.es");

		License licencia = new License().name("MIT License").url("https://opensource.org/license/mit/");

		Info informacion = new Info().license(licencia).title("API REST GAMES MINIVERSE")
				.description("API REST FOR THE GAMES MINIVERSE WEBPAGE")
				.termsOfService("https://www.termsfeed.com/public/uploads/2021/12/sample-terms-of-service-template.pdf")
				.contact(contacto).version("1.0");

		return new OpenAPI().servers(List.of(prodServer)).info(informacion);
	}

}
