package by.lilfrost.servermanager.dto;

import by.lilfrost.servermanager.model.Status;
import lombok.Data;

@Data
public class ServerDto {

    private Long id;
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private Status status;

}
