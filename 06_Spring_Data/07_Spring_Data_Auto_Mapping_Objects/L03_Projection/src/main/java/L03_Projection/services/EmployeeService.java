package L03_Projection.services;

import L03_Projection.entities.dto.*;

import java.util.*;


public interface EmployeeService{
    List<EmployeeDTO> findEmployeesBornBefore(int inputYear);
}
