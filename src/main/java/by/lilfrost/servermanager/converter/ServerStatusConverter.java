package by.lilfrost.servermanager.converter;

import by.lilfrost.servermanager.model.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class ServerStatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status attribute) {
        return Optional.ofNullable(attribute)
                .map(Status::getStatus)
                .orElse(null);
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
//        return Optional.ofNullable(dbData)
//                .map(data -> Status.valueOf(data.replace(" ", "_")))
//                .orElse(null);
//        return Arrays.stream(Status.values())
//                .filter(status -> status.getStatus().equals(dbData))
//                .findFirst()
//                .orElse(null);
        Status status = Status.valueOf(dbData.replace(" ", "_"));
        return status;
    }
}
