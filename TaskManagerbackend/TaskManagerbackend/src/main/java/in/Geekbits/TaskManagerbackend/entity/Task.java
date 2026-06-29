package in.Geekbits.TaskManagerbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Service;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @NotBlank(message  = "Title must not be null")
        @Column(name = "titles" , unique = true)
        private String title;

        @NotBlank(message  = "description must not be null")
        @Column(name = "description")
        private String description;

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        private Status status;

        @Column(name = "date")
        @CreationTimestamp
        private Date createdAt;

}
