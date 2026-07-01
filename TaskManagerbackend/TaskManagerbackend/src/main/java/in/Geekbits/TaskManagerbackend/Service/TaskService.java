package in.Geekbits.TaskManagerbackend.Service;


import in.Geekbits.TaskManagerbackend.DTO.CreateTaskRequest;
import in.Geekbits.TaskManagerbackend.DTO.TaskResponse;
import in.Geekbits.TaskManagerbackend.entity.Task;
import in.Geekbits.TaskManagerbackend.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.EntityResponse;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;




    public TaskResponse saveTask(CreateTaskRequest request){
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status());


        Task newTask  = taskRepository.save(task);


        return new TaskResponse(
                newTask.getId(),
                newTask.getTitle(),
                newTask.getDescription(),
                newTask.getStatus()
        );

    }


    public List<TaskResponse> getAll(){
        List<Task> listOfAllTask = taskRepository.findAll();

       return listOfAllTask
               .stream()
               .map(task -> new TaskResponse(
                       task.getId(),
                       task.getTitle(),
                       task.getDescription(),
                       task.getStatus()
               ))
               .toList();
    }

    public TaskResponse getTask(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Task not found in the data"));


        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }

    public void deleteById(Long taskId){
         taskRepository.deleteById(taskId);
    }


}
























