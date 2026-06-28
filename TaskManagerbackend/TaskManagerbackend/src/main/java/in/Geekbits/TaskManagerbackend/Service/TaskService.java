package in.Geekbits.TaskManagerbackend.Service;


import in.Geekbits.TaskManagerbackend.entity.Task;
import in.Geekbits.TaskManagerbackend.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;



    public Task saveTask(Task task ){
        return taskRepository.save(task);
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


}
























