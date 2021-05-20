package judgev2.web;

import judgev2.data.binding.ExerciseAddBindingModel;
import judgev2.data.service.ExerciseServiceModel;
import judgev2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    private String add(Model model
            , HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("exerciseAddBindingModel")) {
            model.addAttribute("exerciseAddBindingModel"
                    , new ExerciseAddBindingModel());
        }
        return "exercise-add";
    }

    @PostMapping("/add")
    private String addConfirm(
            @Valid ExerciseAddBindingModel exerciseAddBindingModel
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(
                    "exerciseAddBindingModel"
                    , exerciseAddBindingModel
            );

            redirectAttributes.addFlashAttribute("org.springframework" +
                            ".validation.BindingResult" +
                            ".exerciseAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        exerciseService
                .add(
                        modelMapper.map(
                                exerciseAddBindingModel
                                , ExerciseServiceModel.class
                        )
                );

        return "redirect:/";
    }
}
