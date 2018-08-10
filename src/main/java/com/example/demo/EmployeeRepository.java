package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
    ArrayList<Employee> findByFirstname(String firstname);
    ArrayList<Employee> findBydepartment_id(long id);


}
