package judgev2.data.binding;

import javax.validation.constraints.Pattern;

public class HomeworkAddBindingModel {
    private String exercise;
    private String githubAddress;

    public HomeworkAddBindingModel() {
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    @Pattern(regexp = "https://github.com/\\w+/")
    public String getGithubAddress() {
        return githubAddress;
    }

    public void setGithubAddress(String githubAddress) {
        this.githubAddress = githubAddress;
    }
}
