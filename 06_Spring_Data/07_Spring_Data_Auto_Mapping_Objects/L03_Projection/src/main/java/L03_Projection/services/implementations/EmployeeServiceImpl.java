package L03_Projection.services.implementations;

import L03_Projection.entities.*;
import L03_Projection.entities.dto.*;
import L03_Projection.repositories.*;
import L03_Projection.services.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> findEmployeesBornBefore(int inputYear) {

        LocalDate date = LocalDate.of(inputYear, 1, 1);
        List<Employee> employees = this.employeeRepository.findByBirthdayBeforeOrderBySalaryDesc(date);

        ModelMapper modelMapper = new ModelMapper();

        return employees.stream().map(e -> modelMapper.map(e, EmployeeDTO.class)).toList();
    }
}
