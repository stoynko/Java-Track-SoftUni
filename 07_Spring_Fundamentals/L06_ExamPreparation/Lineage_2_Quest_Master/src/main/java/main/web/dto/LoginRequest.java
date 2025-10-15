package main.web.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    @Size(min = 1, max = 12)
    private String username;

    @NotBlank
    @Size(min = 1, max = 12)
    private String password;
}
