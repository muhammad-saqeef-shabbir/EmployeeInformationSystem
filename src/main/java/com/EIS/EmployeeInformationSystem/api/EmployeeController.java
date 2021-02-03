package com.EIS.EmployeeInformationSystem.api;

import com.EIS.EmployeeInformationSystem.dao.EmployeeDataAccessService;
import com.EIS.EmployeeInformationSystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDataAccessService employeeDataAccessService;

    @Autowired EmployeeController(EmployeeDataAccessService employeeDataAccessService) {
        this.employeeDataAccessService = employeeDataAccessService;
    }

    /*@RequestMapping(value="/add", method = RequestMethod.POST)
    public void addEmployee(@NonNull @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.getEmployeeById(id)
                .orElse(null);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Employee> deleteEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.deleteEmployeeById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateEmployeeById(@NonNull @RequestBody Employee employeeToUpdate) {
        employeeService.updateEmployeeById(employeeToUpdate);
    }*/

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addEmployee(@NonNull @RequestBody Employee employee) {
        employeeDataAccessService.insertEmployee(employee);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return employeeDataAccessService.selectAllEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        return employeeDataAccessService.selectEmployeeById(id)
                .orElse(null);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Employee> deleteEmployeeById(@PathVariable("id") Integer id) {
        return employeeDataAccessService.deleteEmployeeById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateEmployeeById(@NonNull @RequestBody Employee employeeToUpdate) {
        employeeDataAccessService.updateEmployeeById(employeeToUpdate);
    }
}
