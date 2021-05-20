package judgev2.data.binding;

import judgev2.data.service.UserServiceModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleChangeBindingModel {
    private String username;
    private String role;
}
