package net.abee.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.abee.emsbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    
}
