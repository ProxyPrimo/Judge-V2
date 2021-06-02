package judgev2.web;

import judgev2.security.CurrentUser;
import judgev2.service.ExerciseService;
import judgev2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ExerciseService exerciseService;
    private final UserService userService;

    @Autowired
    public HomeController(CurrentUser currentUser, ExerciseService exerciseService, UserService userService) {
        this.currentUser = currentUser;
        this.exerciseService = exerciseService;
        this.userService = userService;
    }

    @GetMapping("/")
    private String index(Model model) {
        if (currentUser.isAnonymous()) {
            return "index";
        }

        model.addAttribute("exercises", exerciseService.findAllExerciseNames());
        model.addAttribute("students", userService.findAllUsernames());
        return "home";
    }

}
