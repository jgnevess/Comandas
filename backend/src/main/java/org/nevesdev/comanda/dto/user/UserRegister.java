package org.nevesdev.comanda.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import org.nevesdev.comanda.dto.bar.BarCreate;
import org.nevesdev.comanda.model.bar.Bar;
import org.nevesdev.comanda.model.user.Role;

@Data
@ToString
public class UserRegister {

    @Schema(example = "Super")
    private String username;
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$",
            message = "A senha deve ter no mínimo 8 caracteres, incluindo letra maiúscula, minúscula, número e caractere especial"
    )
    @Schema(example = "Super@123")
    private String passwd;
    @Schema(example = "SUPER")
    private Role role;
    private BarCreate barCreate;

}
