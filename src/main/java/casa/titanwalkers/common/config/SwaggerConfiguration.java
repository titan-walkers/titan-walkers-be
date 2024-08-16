package casa.titanwalkers.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.awt.*;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("API definition - Titan Mail")
                .version("0.1.0")
                .description("for Test");
    }

    @Bean
    public GroupedOpenApi memberOpenApi() {
        String[] paths = { "/v1/member/**" };
        return GroupedOpenApi.builder().group("member").pathsToMatch(paths).build();
    }

}
