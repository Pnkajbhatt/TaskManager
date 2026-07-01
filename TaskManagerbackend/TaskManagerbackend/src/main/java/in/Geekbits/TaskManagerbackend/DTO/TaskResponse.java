package in.Geekbits.TaskManagerbackend.DTO;

import in.Geekbits.TaskManagerbackend.entity.Status;

public record TaskResponse(
        Long id,
        String title,
        String Description,
        Status status
){
}
