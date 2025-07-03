package E01_SoftUni_Game_Store.service.dto;

import jakarta.validation.constraints.*;

public class LoginUserDTO {

    @Pattern(regexp = "^[\\w]+(\\.[\\w]+)*@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})+", message = "Invalid email.")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).{6,}$", message = "Invalid password.")
    private String password;

    public LoginUserDTO() { }

    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
