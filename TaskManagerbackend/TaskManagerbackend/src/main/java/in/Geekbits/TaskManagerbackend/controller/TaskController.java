package in.Geekbits.TaskManagerbackend.controller;


import in.Geekbits.TaskManagerbackend.Service.TaskService;
import in.Geekbits.TaskManagerbackend.entity.Task;
import in.Geekbits.TaskManagerbackend.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/Health")
    public String health(){
        return "working  Fine";
    }



    @PostMapping("/tasks")
    public ResponseEntity<?> createTask(@RequestBody Task task){
       Task savetask = taskService.saveTask(task);
       if(savetask == null){
           return new ResponseEntity<>("error occur",HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(savetask,HttpStatus.CREATED);
    }


    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> data = taskService.GetAll();
        return new ResponseEntity<>(data,HttpStatus.FOUND);
    }



    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getAllTasks(@PathVariable Long id){
        Task data = taskService.getById(id);
        if(data == null){
            return new ResponseEntity<>("Not found of id:"+ id ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data,HttpStatus.FOUND);
    }



    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


 }
