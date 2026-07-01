package in.Geekbits.TaskManagerbackend.controller;


import in.Geekbits.TaskManagerbackend.DTO.CreateTaskRequest;
import in.Geekbits.TaskManagerbackend.DTO.TaskResponse;
import in.Geekbits.TaskManagerbackend.Service.TaskService;
import in.Geekbits.TaskManagerbackend.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/Health")
    public String health(){
        return "working  Fine";
    }



    @PostMapping("/task")
    public ResponseEntity<TaskResponse> createTask(@RequestBody CreateTaskRequest request){
        TaskResponse savetask = taskService.saveTask(request);
        return new ResponseEntity<>(savetask,HttpStatus.CREATED);
    }


    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponse>> getAllTasks(){
        List<TaskResponse> data = taskService.getAll();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }



    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponse> getAllTasks(@PathVariable Long id){
        TaskResponse response = taskService.getTask(id);
        return ResponseEntity.ok(response);
    }








 }
