package by.lilfrost.servermanager.integration;

import by.lilfrost.servermanager.ServerManagerApplicationTests;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(classes = ServerManagerApplicationTests.class)
@Transactional
@ActiveProfiles("test")
@Testcontainers
public abstract class IntegrationTest {

    @Container
    private static final JdbcDatabaseContainer CONTAINER = new PostgreSQLContainer("postgres:14-alpine")
            .withInitScript("sql/init.sql")
            .withDatabaseName("server_manager")
            .withUsername("postgres")
            .withPassword("postgres");

    @BeforeAll
    static void init() {
        CONTAINER.start();
    }

    @DynamicPropertySource
    static void containerProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", CONTAINER::getJdbcUrl);
    }
}
