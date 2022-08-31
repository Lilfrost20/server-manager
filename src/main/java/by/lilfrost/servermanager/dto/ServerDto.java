package by.lilfrost.servermanager.dto;

import by.lilfrost.servermanager.model.Status;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ServerDto {

    private static final String IPV4_PATTERN = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

    private Long id;
    @Pattern(regexp = IPV4_PATTERN)
    private String ipAddress;
    @NotBlank
    private String name;
    private String memory;
    private String type;
    private Status status;
}
