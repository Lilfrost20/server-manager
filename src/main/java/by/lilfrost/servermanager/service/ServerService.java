package by.lilfrost.servermanager.service;

import by.lilfrost.servermanager.dto.ServerDto;
import by.lilfrost.servermanager.exception.ServerCreateErrorException;
import by.lilfrost.servermanager.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import by.lilfrost.servermanager.mapper.ServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.random.RandomGenerator;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ServerService {

    private final ServerRepository serverRepository;


    public ServerDto create(ServerDto server) {
        log.info("Creating new server: {}", server.getName());
        return Optional.of(server)
                .map(ServiceMapper.INSTANCE::serverDtoToServer)
                .map(serverRepository::save)
                .map(ServiceMapper.INSTANCE::serverToServerDto)
                .orElseThrow(
                        () -> new ServerCreateErrorException("Error creating server %s"
                                .formatted(server.getName())));
    }

    @Transactional(readOnly = true)
    public Page<ServerDto> findAll(Pageable pageable) {
        log.info("Fetching all services");
        return serverRepository.findAll(pageable)
                .map(ServiceMapper.INSTANCE::serverToServerDto);
    }

    @Transactional(readOnly = true)
    public Optional<ServerDto> get(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverRepository.findById(id)
                .map(ServiceMapper.INSTANCE::serverToServerDto);
    }


    public Boolean delete(Long id) {
        return serverRepository.findById(id)
                .map(server -> {
                    serverRepository.delete(server);
                    serverRepository.flush();
                    return true;
                }).orElse(false);
    }


    private String setServerImageUrl() {
        int minValue = 1;
        int maxValue = 4;
        int result = (int) (Math.random()*(maxValue-minValue+1)+minValue);
        Path path = Path.of("resources", "static", "images", "server%s.png".formatted(result));
        return path.toString();
    }
}
