package by.lilfrost.servermanager.model;

import lombok.Getter;

@Getter
public enum Status {
    SERVER_UP("SERVER UP"),
    SERVER_DOWN("SERVER DOWN");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}
