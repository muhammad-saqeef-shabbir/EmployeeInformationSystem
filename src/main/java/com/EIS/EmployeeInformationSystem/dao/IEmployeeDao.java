package com.EIS.EmployeeInformationSystem.dao;

import com.EIS.EmployeeInformationSystem.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeDao {
    /*int insertEmployee(UUID id, Employee employee);

    default int insertEmployee(Employee employee) {
        UUID id = UUID.randomUUID();
        return insertEmployee(id, employee);
    }*/

    int insertEmployee(Employee employee);

    List<Employee> selectAllEmployees();

    Optional<Employee> selectEmployeeById(Integer id);

    List<Employee> deleteEmployeeById(Integer id);

    int updateEmployeeById(Employee employee);
}
