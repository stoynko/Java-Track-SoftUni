package E01_SoftUni_Game_Store.service.implementations;

import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.data.repositories.*;
import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import jakarta.validation.*;
import org.hibernate.validator.messageinterpolation.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String registerUser(CreateUserDTO userCreationDTO) {

        if (!userCreationDTO.getPassword().equals(userCreationDTO.getPasswordConfirmation())) {
            return "Passwords do not match.";
        }

        Validator validator = Validation.byDefaultProvider().configure()
                                        .messageInterpolator(new ParameterMessageInterpolator())
                                        .buildValidatorFactory().getValidator();
        Set<ConstraintViolation<CreateUserDTO>> constraintViolationSet = validator.validate(userCreationDTO);

        System.out.println();
        if (!constraintViolationSet.isEmpty()) {
            return constraintViolationSet.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(" | "));
        }
            User user = this.modelMapper.map(userCreationDTO, User.class);
            setRootUserAsAdmin(user);
            this.usersRepository.saveAndFlush(user);
            return String.format("%s was registered successfully!", user.getFullName());
    }

    private void setRootUserAsAdmin(User user) {
        if (this.usersRepository.count() == 0) {
            user.setAdmin(true);
        }
    }
}
