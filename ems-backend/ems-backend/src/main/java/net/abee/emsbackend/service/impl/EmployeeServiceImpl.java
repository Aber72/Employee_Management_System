package net.abee.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.abee.emsbackend.Mapper.EmployeeMapper;
import net.abee.emsbackend.ddo.EmployeeDto;
import net.abee.emsbackend.entity.Employee;
import net.abee.emsbackend.exception.ResourceNotFoundException;
import net.abee.emsbackend.repository.EmployeeRepository;
import net.abee.emsbackend.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
       Employee savedEmployee = employeeRepository.save(employee);
       
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

      Employee employee=  employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exits with given id :  "+ employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
        
        
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
       return employees.stream().map(
        (employee)-> EmployeeMapper.mapToEmployeeDto(employee))
        .collect(Collectors.toList());
        
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(
        ()-> new ResourceNotFoundException
        ("Employee is not exits with the given id: "+ employeeId) );

        employee.setFirstName(updatedEmployee.getFirstname());
        employee.setLastname(updatedEmployee.getLastname());
        employee.setEmail(updatedEmployee.getEmail());

       Employee updatesEmployeeobj= employeeRepository.save(employee);

       return EmployeeMapper.mapToEmployeeDto(updatesEmployeeobj);



    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
        ()-> new ResourceNotFoundException
        ("Employee is not exits with the given id: "+ employeeId) );

        employeeRepository.deleteById(employeeId);
    }
    
}
