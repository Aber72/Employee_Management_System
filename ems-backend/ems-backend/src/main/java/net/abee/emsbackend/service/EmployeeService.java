package net.abee.emsbackend.service;

import java.util.List;

import net.abee.emsbackend.ddo.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);


    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee (Long employeeId , EmployeeDto updatedEmployee);

    void deleteEmployee( Long employeeId);

    
}
