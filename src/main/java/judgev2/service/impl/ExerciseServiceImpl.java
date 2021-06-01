package judgev2.service.impl;

import judgev2.data.entity.ExerciseEntity;
import judgev2.data.service.ExerciseServiceModel;
import judgev2.repository.ExerciseRepository;
import judgev2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ExerciseServiceModel exerciseServiceModel) {
        exerciseRepository
                .saveAndFlush(
                        modelMapper.map(
                                exerciseServiceModel
                                , ExerciseEntity.class
                        )
                );
    }

    @Override
    public List<String> findAllExerciseNames() {
        return
                exerciseRepository
                        .findAllExerciseNames();
    }
}
