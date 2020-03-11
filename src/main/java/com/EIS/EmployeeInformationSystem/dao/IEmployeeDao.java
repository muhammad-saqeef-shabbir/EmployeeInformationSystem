package com.EIS.EmployeeInformationSystem.dao;

import com.EIS.EmployeeInformationSystem.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeDao {
    /*int insertEmployee(UUID id, Employee employee);

    default int insertEmployee(Employee employee) {
        UUID id = UUID.randomUUID();
        return insertEmployee(id, employee);
    }*/

    int insertEmployee(Employee employee);

    List<Employee> selectAllPeople();

    Optional<Employee> selectEmployeeById(UUID id);

    List<Employee> deleteEmployeeById(UUID id);

    int updateEmployeeById(Employee employee);
}
