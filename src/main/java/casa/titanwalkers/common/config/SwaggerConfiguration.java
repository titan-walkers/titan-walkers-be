package casa.titanwalkers.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private final OpenAPI customOpenApi;

    @Bean
    public OpenAPI openApi() {
        Info info = new Info().title("API definition - Titan Mail")
                .version("0.1.0")
                .description("for Test");
        return customOpenApi.info(info);
    }

}
