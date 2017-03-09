package be.g00glen00b;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import io.github.robwin.swagger.test.SwaggerAssertions;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest

public class SpringBootSwaggerApplicationTests {
    @Value("http://localhost:${local.server.port}/v2/api-docs?group=task-api")
    private String swaggerApi;

    @Test
    public void apiMatchesDefinition() throws IOException {
        SwaggerAssertions.assertThat(swaggerApi).isEqualTo(new ClassPathResource("swagger.yml").getFile().getPath());
    }
}