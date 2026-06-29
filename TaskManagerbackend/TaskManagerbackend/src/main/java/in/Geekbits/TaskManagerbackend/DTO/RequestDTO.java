package in.Geekbits.TaskManagerbackend.DTO;

import in.Geekbits.TaskManagerbackend.entity.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RequestDTO {

    private String title;

    private String description;

    private Status status;

}
