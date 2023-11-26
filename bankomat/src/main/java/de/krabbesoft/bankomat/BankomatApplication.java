package de.krabbesoft.bankomat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletConfig;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Context;

@ApplicationPath("/restapi")
public class BankomatApplication extends Application {
	
	public BankomatApplication(@Context ServletConfig servletConfig) {
		try {
			initSwagger(servletConfig);
		} catch (OpenApiConfigurationException e) {
			/* Swagger ist nicht überlebenswichtig, da können wir drüber wegsehen */
			e.printStackTrace();
		}
	}
	
	private void initSwagger(ServletConfig servletConfig) throws OpenApiConfigurationException {
		OpenAPI openApi = new OpenAPI();
        Info info = new Info()
                .title("Bankomat Api Dokumentation")
                .description("Die Dokumentation über die Api Methoden, die der Bankomat zur Verfügung stellt.");

        Server server = new Server()
        		.url(servletConfig.getServletContext().getContextPath())
        		.description("Bankomat-Anwendung");

        openApi.info(info);
        openApi.addServersItem(server);
        
        SwaggerConfiguration swaggerConfig = new SwaggerConfiguration()
                .openAPI(openApi)
                .prettyPrint(true)
                .resourcePackages(Stream.of("de.krabbesoft.bankomat.resources").collect(Collectors.toSet()));

        new JaxrsOpenApiContextBuilder<>()
                .servletConfig(servletConfig)
                .application(this)
                .openApiConfiguration(swaggerConfig)
                .buildContext(true);
	}

}
