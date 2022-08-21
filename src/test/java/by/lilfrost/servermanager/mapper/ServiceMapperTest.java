package by.lilfrost.servermanager.mapper;

import by.lilfrost.servermanager.dto.ServerDto;
import by.lilfrost.servermanager.model.Server;
import by.lilfrost.servermanager.model.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ServiceMapperTest {

    @Test
    void serverDtoToServer() {
        ServerDto inputServer = ServerDto.builder()
                .ipAddress("240.251.68.10")
                .name("Wisozk")
                .memory("32 GB")
                .type("Muncar server")
                .status(Status.SERVER_DOWN)
                .build();
        Server outputServer = ServiceMapper.INSTANCE.serverDtoToServer(inputServer);
        assertEquals(outputServer.getIpAddress(), inputServer.getIpAddress());
        assertEquals(outputServer.getName(),inputServer.getName());
        assertEquals(outputServer.getMemory(),inputServer.getMemory());
        assertEquals(outputServer.getType(),inputServer.getType());
        assertSame(outputServer.getStatus(),inputServer.getStatus());

    }

    @Test
    void serverToServerDto() {

    }
}