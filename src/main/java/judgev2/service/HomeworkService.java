package judgev2.service;

import judgev2.data.entity.HomeworkEntity;
import judgev2.data.service.HomeworkServiceModel;

public interface HomeworkService {
    HomeworkServiceModel findByScoring();

    void addHomework(String exercise, String githubAddress);

    HomeworkEntity findById(String homeworkId);
}
