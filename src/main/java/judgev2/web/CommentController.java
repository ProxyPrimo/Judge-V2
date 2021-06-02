package judgev2.web;

import judgev2.data.binding.CommentAddBindingModel;
import judgev2.data.service.CommentServiceModel;
import judgev2.data.view.HomeworkViewModel;
import judgev2.service.CommentService;
import judgev2.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final HomeworkService homeworkService;
    private final ModelMapper modelMapper;
    private final CommentService commentService;

    @Autowired
    public CommentController(HomeworkService homeworkService, ModelMapper modelMapper, CommentService commentService) {
        this.homeworkService = homeworkService;
        this.modelMapper = modelMapper;
        this.commentService = commentService;
    }

    @GetMapping("/add")
    private String add(Model model) {

        if (!model.containsAttribute("commentAddBindingModel")) {
            model.addAttribute("commentAddBindingModel", new CommentAddBindingModel());
        }

        model.addAttribute("homework"
                , modelMapper.map(homeworkService.findByScoring()
                        , HomeworkViewModel.class));

        return "homework-check";
    }

    @PostMapping("/add")
    private String addConfirm(@Valid CommentAddBindingModel commentAddBindingModel
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentAddBindingModel", commentAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.commentAddBindingModel"
                    , bindingResult);
            return "redirect:add";
        }

        // TODO save in DB
        CommentServiceModel commentServiceModel = modelMapper
                .map(commentAddBindingModel, CommentServiceModel.class);

        commentService.add(commentServiceModel, commentAddBindingModel.getHomeworkId());

        return "redirect:/";
    }
}
