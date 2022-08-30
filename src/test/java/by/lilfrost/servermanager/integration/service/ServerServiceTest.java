package by.lilfrost.servermanager.integration.service;

import by.lilfrost.servermanager.dto.ServerDto;
import by.lilfrost.servermanager.integration.IntegrationTest;
import by.lilfrost.servermanager.model.Status;
import by.lilfrost.servermanager.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ServerServiceTest extends IntegrationTest {

    private final ServerService serverService;

    private final static Long VALID_SERVER_ID = 5L;
    private final static Long INVALID_SERVER_ID = 11L;

    @Test
    void create() {
        ServerDto server = ServerDto.builder()
                .ipAddress("240.250.68.10")
                .name("Wisozk")
                .memory("32 GB")
                .type("Muncar server")
                .status(Status.SERVER_DOWN)
                .build();
        ServerDto result = serverService.create(server);

        assertAll(() -> assertEquals(server.getIpAddress(), result.getIpAddress()),
                () -> assertEquals(server.getName(), result.getName()),
                () -> assertEquals(server.getMemory(), result.getMemory()),
                () -> assertEquals(server.getType(), result.getType()),
                () -> assertSame(server.getStatus(), result.getStatus()));
    }

    @Test
    @Transactional(readOnly = true)
    void findAll() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<ServerDto> serversList = serverService.findAll(pageable);

        assertThat(serversList).hasSize(5);
    }

    @Test
    @Transactional(readOnly = true)
    void get() {
        Optional<ServerDto> validServer = serverService.get(VALID_SERVER_ID);
        Optional<ServerDto> inValidServer = serverService.get(INVALID_SERVER_ID);

        assertAll(() -> assertThat(validServer).isPresent(),
                () -> assertThat(inValidServer).isEmpty());


    }

    @Test
    void delete() {
        Boolean isDeleted = serverService.delete(VALID_SERVER_ID);
        Boolean isDoNotDeleted = serverService.delete(INVALID_SERVER_ID);

        assertAll(() -> assertTrue(isDeleted),
                () -> assertFalse(isDoNotDeleted));
    }
}