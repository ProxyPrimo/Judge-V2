package judgev2.web;

import judgev2.security.CurrentUser;
import judgev2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final CurrentUser currentUser;
    private final UserService userService;

    public RoleController(CurrentUser currentUser, UserService userService) {
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @GetMapping("/change")
    private String change(Model model) {

        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }

        model.addAttribute("names", userService.findAllUsernames());
        return "role-change";
    }
}
