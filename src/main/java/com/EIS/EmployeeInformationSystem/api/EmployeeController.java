package com.EIS.EmployeeInformationSystem.api;

import com.EIS.EmployeeInformationSystem.model.Employee;
import com.EIS.EmployeeInformationSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addEmployee(@NonNull @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Employee> getAllPeople() {
        return employeeService.getAllPeople();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") UUID id) {
        return employeeService.getEmployeeById(id)
                .orElse(null);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Employee> deleteEmployeeById(@PathVariable("id") UUID id) {
        return employeeService.deleteEmployeeById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateEmployeeById(@NonNull @RequestBody Employee employeeToUpdate) {
        employeeService.updateEmployeeById(employeeToUpdate);
    }
}
