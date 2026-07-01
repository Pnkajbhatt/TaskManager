package in.Geekbits.TaskManagerbackend.DTO;

import in.Geekbits.TaskManagerbackend.entity.Status;


public record CreateTaskRequest(String title,
                                String description,
                                Status status) { }
