package E01_SoftUni_Game_Store.service.implementations;

import E01_SoftUni_Game_Store.data.common.*;
import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.data.repositories.*;
import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import E01_SoftUni_Game_Store.service.utilities.*;
import jakarta.validation.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.stream.*;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validator;
    private final SessionManager<User> userSessionManager;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper, ValidatorUtil validator, SessionManager<User> userSessionManager) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.userSessionManager = userSessionManager;
    }

    @Override
    public String registerUser(CreateUserDTO userCreationDTO) {

        if (this.usersRepository.findUserByEmail(userCreationDTO.getEmail()) != null) {
            return SystemErrorMessage.REGISTRATION_EMAIL_EXISTS;
        }

        if (!userCreationDTO.getPassword().equals(userCreationDTO.getPasswordConfirmation())) {
            return SystemErrorMessage.REGISTRATION_PASSWORD_MISMATCH;
        }

        if (!validator.isValid(userCreationDTO)) {
            return validator.validate(userCreationDTO)
                            .stream().map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining(" | "));
        }

        User user = this.modelMapper.map(userCreationDTO, User.class);
        setRootUserAsAdmin(user);
        this.usersRepository.saveAndFlush(user);
        return String.format(ConsoleLogMessage.REGISTRATION_SUCCESSFULL, user.getFullName());
    }

    @Override
    public String loginUser(LoginUserDTO loginUserDTO) {
        Optional<User> user = this.usersRepository.findUserByEmailAndPassword(loginUserDTO.getEmail(), loginUserDTO.getPassword());
        if (!userSessionManager.hasActiveSession() && user.isPresent()) {
            userSessionManager.setActiveSession(user.get());
            return String.format(ConsoleLogMessage.LOGIN_SUCCESSFULL, user.get().getFullName());
        } else {
            return SystemErrorMessage.LOGIN_INCORRECT_DATA;
        }
    }

    @Override
    public boolean isAdmin() {
        return this.userSessionManager.hasActiveSession() && this.userSessionManager.getActiveSession().isAdmin();
    }

    @Override
    public String logoutUser() {
        if (userSessionManager.hasActiveSession()) {
            User loggedUser = userSessionManager.getActiveSession();
            userSessionManager.terminateActiveSession();
            return String.format(ConsoleLogMessage.LOGOUT_SUCCESSFULL, loggedUser.getFullName());
        } else {
            return SystemErrorMessage.LOGOUT_NO_ACTIVE_SESSION;
        }
    }

    private void setRootUserAsAdmin(User user) {
        if (this.usersRepository.count() == 0) {
            user.setAdmin(true);
        }
    }
}
