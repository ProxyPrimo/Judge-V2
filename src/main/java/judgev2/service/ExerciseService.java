package judgev2.service;

import judgev2.data.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void add(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExerciseNames();
}
