package by.lilfrost.servermanager.controller;

import by.lilfrost.servermanager.dto.ServerDto;
import by.lilfrost.servermanager.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/servers")
public class ServiceController {

    private final ServerService serverService;

    @GetMapping
    public ResponseEntity<List<ServerDto>> getAll() {
        return new ResponseEntity<>(serverService.findAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServerDto> get(@PathVariable("id") Long id) {
        return serverService.get(id)
                .map(serverDto -> ResponseEntity.ok()
                        .body(serverDto))
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping()
    public ResponseEntity<ServerDto> create(@Valid @RequestBody ServerDto server) {
        return ResponseEntity.status(CREATED)
                .body(serverService.create(server));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return serverService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
