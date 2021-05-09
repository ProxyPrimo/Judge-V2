package judgev2.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "homework")
@Getter
@Setter
@NoArgsConstructor
public class HomeworkEntity extends BaseEntity {

    @Column(name = "added_on", nullable = false)
    private LocalDateTime addedOn;

    @Column(name = "github_address", nullable = false, unique = true)
    private String githubAddress;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private ExerciseEntity exerciseEntity;
}
