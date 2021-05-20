package judgev2.web;

import judgev2.data.binding.RoleChangeBindingModel;
import judgev2.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final CurrentUser currentUser;

    public RoleController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/change")
    private String change(Model model) {

        if (currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }

        else if (model
                .containsAttribute("roleChangeBindingModel")) {
            model
                    .addAttribute("roleChangeBindingModel"
                            , new RoleChangeBindingModel());
        }
        return "role-add";
    }
}
