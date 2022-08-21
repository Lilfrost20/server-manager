package by.lilfrost.servermanager.mapper;

import by.lilfrost.servermanager.dto.ServerDto;
import by.lilfrost.servermanager.model.Server;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    Server serverDtoToServer(ServerDto serverDto);

    ServerDto serverToServerDto(Server server);
}
