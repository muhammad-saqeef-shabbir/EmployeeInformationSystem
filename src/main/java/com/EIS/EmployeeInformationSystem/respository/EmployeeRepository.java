package com.EIS.EmployeeInformationSystem.respository;

import com.EIS.EmployeeInformationSystem.dao.IEmployeeDao;
import com.EIS.EmployeeInformationSystem.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Qualifier("employees")
@Repository
public class EmployeeRepository implements IEmployeeDao {

    @Override
    public int insertEmployee(Employee employee) {
        return 0;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return null;
    }

    @Override
    public Optional<Employee> selectEmployeeById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> deleteEmployeeById(Integer id) {
        return null;
    }

    @Override
    public int updateEmployeeById(Employee employee) {
        return 0;
    }
}
