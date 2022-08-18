package by.lilfrost.servermanager.repository;

import by.lilfrost.servermanager.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long> {

    @Query("select s from Server s where s.ipAddress = :ipAddress")
    Optional<Server> findByIpAddress(String ipAddress);
}
