package judgev2.data.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;


@Getter
@Setter
@NoArgsConstructor
public class HomeworkAddBindingModel {
    private String exercise;

    @Pattern(regexp = "https://github.com/\\w+/")
    private String githubAddress;
}
