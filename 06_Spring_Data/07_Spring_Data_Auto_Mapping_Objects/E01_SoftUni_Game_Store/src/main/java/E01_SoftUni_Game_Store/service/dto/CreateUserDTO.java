package E01_SoftUni_Game_Store.service.dto;

import jakarta.validation.constraints.*;

public class CreateUserDTO {

    @Pattern(regexp = "^[\\w]+(\\.[\\w]+)*@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})+", message = "Invalid email.")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).{6,}$", message = "Invalid password.")
    private String password;
    private String passwordConfirmation;
    private String fullName;

    public CreateUserDTO() { }

    public CreateUserDTO(String email, String password, String passwordConfirmation, String fullName) {
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public String getFullName() {
        return fullName;
    }
}
