package E01_SoftUni_Game_Store.service;

import E01_SoftUni_Game_Store.service.dto.*;

public interface UserService {

    String registerUser(CreateUserDTO userCreationDTO);
    String loginUser(LoginUserDTO loginUserDTO);
    boolean isAdmin();
    String logoutUser();
}
