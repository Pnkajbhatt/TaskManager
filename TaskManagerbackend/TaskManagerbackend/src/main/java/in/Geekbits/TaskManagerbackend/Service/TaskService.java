package in.Geekbits.TaskManagerbackend.Service;


import in.Geekbits.TaskManagerbackend.entity.Task;
import in.Geekbits.TaskManagerbackend.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;



    public Optional<Task> saveTask(Task task) {
        if (taskRepository.existsByTitle(task.getTitle())) {
            return Optional.empty();
        }
        return Optional.of(taskRepository.save(task));
    }


    public List<Task> GetAll(){
        return taskRepository.findAll();
    }

    public Task getById(Long taskId){
        return taskRepository.findById(taskId)
                .orElseThrow(()->new RuntimeException("User not found"));
    }

    public void deleteById(Long taskId){
         taskRepository.deleteById(taskId);
    }


    public String UpdateTask(Long task){
        taskRepository.
    }




}
























