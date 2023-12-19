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
	@Value("${server-desc}")
	private String severDesc;
	@Value("${api-name}")
	private String apiName;
	@Value("${contact}")
	private String contact;
	@Value("${license-name}")
	private String licenseName;
	@Value("${license-url}")
	private String licenseUrl;
	@Value("${info-title}")
	private String infoTitle;
	@Value("${info-desc}")
	private String infoDesc;
	@Value("${info-tos}")
	private String infoTOS;
	@Value("${info-version}")
	private String infoVersion;

	@Bean
	public OpenAPI myOpenAPI() {
		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription(severDesc);

		Contact contacto = new Contact().name(apiName)
				.email(contact);

		License licencia = new License().name(licenseName).url(licenseUrl);

		Info informacion = new Info().license(licencia).title(infoTitle)
				.description(infoDesc)
				.termsOfService(infoTOS)
				.contact(contacto).version(infoVersion);

		return new OpenAPI().servers(List.of(prodServer)).info(informacion);
	}

}
