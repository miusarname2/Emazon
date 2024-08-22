package com.pragma.Emazon.infrastructure.documentation;

import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class OpenApiConfigurationTest {

    @Test
    void testOpenApiConfiguration() {
        // Arrange
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(OpenApiConfiguration.class);
        OpenAPI openAPI = context.getBean(OpenAPI.class);

        // Assert
        assertNotNull(openAPI, "OpenAPI bean should not be null");
        assertNotNull(openAPI.getInfo(), "OpenAPI info should not be null");
        assertNotNull(openAPI.getInfo().getTitle(), "OpenAPI title should not be null");

        // Clean up
        context.close();
    }

}