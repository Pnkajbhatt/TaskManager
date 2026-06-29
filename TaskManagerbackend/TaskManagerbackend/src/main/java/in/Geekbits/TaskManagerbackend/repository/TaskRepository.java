package in.Geekbits.TaskManagerbackend.repository;

import in.Geekbits.TaskManagerbackend.entity.Task;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    boolean existsByTitle(@NotBlank(message  = "Title must not be null") @UniqueElements String title);
}
