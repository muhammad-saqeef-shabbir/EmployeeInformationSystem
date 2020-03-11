package com.EIS.EmployeeInformationSystem.dao;

import com.EIS.EmployeeInformationSystem.model.Employee;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*("postgres")*/
@Repository
public class EmployeeDataAccessService implements IEmployeeDao {

    EbeanServer server = Ebean.getServer("db");

    @Override
    @Transactional
    public int insertEmployee(Employee employee) {
        Employee employee1 = new Employee(UUID.randomUUID(), employee.getName(), employee.getRole(), employee.getCnic(), employee.getAge(), employee.getDob());
        server.save(employee1);
        return 1;
    }

    @Override
    @Transactional
    public List<Employee> selectAllPeople() {
        List<Employee> employees = server.find(Employee.class).findList();
        return employees;
    }

    @Override
    @Transactional
    public Optional<Employee> selectEmployeeById(UUID id) {
        Employee employee = Ebean.find(Employee.class, id);
        return Optional.ofNullable(employee);
    }

    @Override
    @Transactional
    public List<Employee> deleteEmployeeById(UUID id) {
        Employee employee = Ebean.find(Employee.class, id);
        server.delete(employee);
        List<Employee> employees = server.find(Employee.class).findList();
        return employees;
    }

    @Override
    @Transactional
    public int updateEmployeeById(Employee employee) {
        String sql = "UPDATE employee set name = :name, role = :role, cnic = :cnic, age = :age, dob = :dob where id = :id";
//        server.update(employee);
        int row = server.sqlUpdate(sql)
                .setParameter("name",employee.getName())
                .setParameter("role",employee.getRole())
                .setParameter("cnic",employee.getCnic())
                .setParameter("age",employee.getAge())
                .setParameter("dob",employee.getDob())
                .setParameter("id",employee.getId())
                .execute();
        return row;
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
