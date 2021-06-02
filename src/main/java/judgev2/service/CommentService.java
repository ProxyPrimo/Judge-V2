package judgev2.service;

import judgev2.data.service.CommentServiceModel;

public interface CommentService {
    void add(CommentServiceModel commentServiceModel, String homeworkId);
}
