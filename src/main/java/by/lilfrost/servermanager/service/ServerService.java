package by.lilfrost.servermanager.service;

import by.lilfrost.servermanager.dto.ServerDto;
import by.lilfrost.servermanager.exception.ServerCreateErrorException;
import by.lilfrost.servermanager.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import by.lilfrost.servermanager.mapper.ServiceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ServerService {

    private final ServerRepository serverRepository;
    private final ServiceMapper serviceMapper;

    public ServerDto create(ServerDto server) {
        log.info("Creating new server: {}", server.getName());
        return Optional.of(server)
                .map(serviceMapper::serverDtoToServer)
                .map(serverRepository::save)
                .map(serviceMapper::serverToServerDto)
                .orElseThrow(
                        () -> new ServerCreateErrorException("Error creating server %s"
                                .formatted(server.getName())));
    }

    //Need refactor to pageable
    @Transactional(readOnly = true)
    public List<ServerDto> findAll() {
        log.info("Fetching all services");
        return serverRepository.findAll().stream()
                .map(serviceMapper::serverToServerDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public Optional<ServerDto> get(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverRepository.findById(id)
                .map(serviceMapper::serverToServerDto);
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
        return null;
    }
}
