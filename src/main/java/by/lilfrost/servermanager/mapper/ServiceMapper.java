package by.lilfrost.servermanager.mapper;

import by.lilfrost.servermanager.dto.ServerDto;
import by.lilfrost.servermanager.model.Server;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface ServiceMapper {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    Server serverDtoToServer(ServerDto serverDto);

    ServerDto serverToServerDto(Server server);
}
