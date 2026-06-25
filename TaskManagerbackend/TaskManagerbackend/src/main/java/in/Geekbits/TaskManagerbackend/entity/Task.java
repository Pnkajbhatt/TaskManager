package in.Geekbits.TaskManagerbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
        @Column(name = "ID")
        private Long id;

        @NotBlank(message  = "Title must not be null")
        @Column(name = "Titles")
        private String title;

        @NotBlank(message  = "description must not be null")
        @Column(name = "description")
        private String string;

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        private Status status;

        @Column(name = "date")
        private Date createdAt;

}
