package judgev2.service.impl;

import judgev2.data.entity.CommentEntity;
import judgev2.data.service.CommentServiceModel;
import judgev2.repository.CommentRepository;
import judgev2.security.CurrentUser;
import judgev2.service.CommentService;
import judgev2.service.HomeworkService;
import judgev2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final HomeworkService homeworkService;


    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser, HomeworkService homeworkService) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.homeworkService = homeworkService;
    }


    @Override
    public void add(CommentServiceModel commentServiceModel, String homeworkId) {
        CommentEntity commentEntity = modelMapper
                .map(commentServiceModel
                        , CommentEntity.class);

        commentEntity.setAuthor(userService
                .findById(currentUser.getId()));

        commentEntity.setHomework(homeworkService
                .findById(homeworkId));

        commentRepository.saveAndFlush(commentEntity);
    }

    @Override
    public Double findAvgScore() {
        return commentRepository.findAverageScore();
    }
}
