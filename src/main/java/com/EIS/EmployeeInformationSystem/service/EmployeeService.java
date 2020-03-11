package com.EIS.EmployeeInformationSystem.service;

import com.EIS.EmployeeInformationSystem.dao.IEmployeeDao;
import com.EIS.EmployeeInformationSystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final IEmployeeDao employeeDao;

    @Autowired
    public EmployeeService(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }/*@Qualifier("postgres")*/

    public int addEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    public List<Employee> getAllPeople() {
        return employeeDao.selectAllPeople();
    }

    public Optional<Employee> getEmployeeById(UUID id) {
        return employeeDao.selectEmployeeById(id);
    }

    public List<Employee> deleteEmployeeById(UUID id) {
        return employeeDao.deleteEmployeeById(id);
    }

    public int updateEmployeeById(Employee newEmployee) {
        return employeeDao.updateEmployeeById(newEmployee);
    }
}