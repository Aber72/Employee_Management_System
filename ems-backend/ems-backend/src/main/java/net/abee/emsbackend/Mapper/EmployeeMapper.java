package net.abee.emsbackend.Mapper;

import net.abee.emsbackend.ddo.EmployeeDto;
import net.abee.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee savedEmployee){
        return new EmployeeDto(
            savedEmployee.getId(),
            savedEmployee.getFirstName(),
            savedEmployee.getLastname(),
            savedEmployee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee( 
            employeeDto.getId(),
            employeeDto.getFirstname(),
            employeeDto.getLastname(),
            employeeDto.getEmail()
        );
    }
    
}
