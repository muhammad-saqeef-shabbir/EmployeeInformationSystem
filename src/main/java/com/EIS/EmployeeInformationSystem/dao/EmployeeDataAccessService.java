package com.EIS.EmployeeInformationSystem.dao;

import com.EIS.EmployeeInformationSystem.model.Employee;
import com.EIS.EmployeeInformationSystem.respository.EmployeeRepository;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeDataAccessService {

    EbeanServer ebeanServer = Ebean.getServer("db");

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired EmployeeDataAccessService (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public int insertEmployee(Employee employee) {
        /*Employee employee1 = new Employee(UUID.randomUUID(), employee.getName(), employee.getRole(), employee.getCnic(), employee.getAge(), employee.getDob());
        server.save(employee1);*/
        return 1;
    }

    public List<Employee> selectAllEmployees() {
        /*List<Employee> employees = ebeanServer.find(Employee.class).findList();*/
        return null;
    }

    public Optional<Employee> selectEmployeeById(Integer id) {
        /*Employee employee = Ebean.find(Employee.class, id);*/
        return null;
    }

    public List<Employee> deleteEmployeeById(Integer id) {
        /*Employee employee = Ebean.find(Employee.class, id);
        ebeanServer.delete(employee);
        List<Employee> employees = ebeanServer.find(Employee.class).findList();*/
        return null;
    }

    public int updateEmployeeById(Employee employee) {
        /*String sql = "UPDATE employee set name = :name, role = :role, cnic = :cnic, age = :age, dob = :dob where id = :id";*/
//        server.update(employee);
        /*int row = server.sqlUpdate(sql)
                .setParameter("name",employee.getName())
                .setParameter("role",employee.getRole())
                .setParameter("cnic",employee.getCnic())
                .setParameter("age",employee.getAge())
                .setParameter("dob",employee.getDob())
                .setParameter("id",employee.getId())
                .execute();*/

        /*ebeanServer.update(employee);*/
        return 1;
    }

    /*public final JdbcTemplate jdbcTemplate;*/

    /*@Autowired
    public EmployeeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

     /* @Override
    public int insertEmployee(Employee employee) {
        *//*String sqlQuery = "INSERT INTO employee (id, name, role, cnic, age, dob) VALUES (?, ?, ?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sqlQuery, UUID.randomUUID(), employee.getName(), employee.getRole(), employee.getCnic(), employee.getAge(), employee.getDob());
        return rowsAffected;*//*
    }*/

    /*@Override
    public List<Employee> selectAllPeople() {
        *//*List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee (UUID.randomUUID(), "FROM POSTGRES DB"));
        return employeeList;*//*

        String sqlQuery = "SELECT id, name, role, cnic, age, dob from employee";
        return jdbcTemplate.query(sqlQuery, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String role = resultSet.getString("role");
            String cnic = resultSet.getString("cnic");
            int age = resultSet.getInt("age");
            Date dob = resultSet.getDate("dob");

            return new Employee(id, name, role, cnic, age, dob);
        });
    }*/

    /*@Override
    public Optional<Employee> selectEmployeeById(UUID id) {
        final String sqlQuery = "SELECT id, name, role, cnic, age, dob FROM employee WHERE id = ?";

        Employee employee = jdbcTemplate.queryForObject(sqlQuery, new Object[]{id},
                (resultSet, i) -> {
                    UUID employeeId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String role = resultSet.getString("role");
                    String cnic = resultSet.getString("cnic");
                    int age = resultSet.getInt("age");
                    Date dob = resultSet.getDate("dob");

                    return new Employee(id, name, role, cnic, age, dob);
                });

        return Optional.ofNullable(employee);
    }*/

    /*@Override
    public List<Employee> deleteEmployeeById(UUID id) {
        String sqlQuery = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sqlQuery, id);
        return selectAllPeople();
    }

    @Override
    public int updateEmployeeById(Employee employee) {
        String sqlQuery = "UPDATE employee SET name = ?, role = ?, cnic = ?, age = ?, dob = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sqlQuery, employee.getName(), employee.getRole(), employee.getCnic(), employee.getAge(), employee.getDob(), employee.getId());
        return rowsAffected;
    }*/
}
