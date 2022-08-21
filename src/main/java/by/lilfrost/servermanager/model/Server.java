package by.lilfrost.servermanager.model;

import by.lilfrost.servermanager.converter.ServerStatusConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "server")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ip_address", unique = true, nullable = false)
    private String ipAddress;

    private String name;
    private String memory;
    private String type;

    @Convert(converter = ServerStatusConverter.class)
    @Enumerated(EnumType.STRING)
    private Status status;

}
