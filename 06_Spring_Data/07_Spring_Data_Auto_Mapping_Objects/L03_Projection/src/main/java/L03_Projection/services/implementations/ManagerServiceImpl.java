package L03_Projection.services.implementations;

import L03_Projection.entities.*;
import L03_Projection.entities.dto.*;
import L03_Projection.repositories.*;
import L03_Projection.services.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public ManagerServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDTO> findAllManagers() {
        List<Employee> managers = employeeRepository.findAllManagers();
        return List.of();
    }
}
