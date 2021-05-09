package judgev2.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "text_content", nullable = false, columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private HomeworkEntity homework;

}
