package school.hei.helloworldapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @Column(name = "id_student", length = 9)
    private String idStudent;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "boolean default true")
    private Boolean active;
}
