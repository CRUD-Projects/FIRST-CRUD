package com.antonromanov.firstcrud.firstcrud.repositories;

import com.antonromanov.firstcrud.firstcrud.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    @Query(value = "SELECT distinct s.name FROM Employee s")
    List<String> passsedInCourse();

    @Query(value = "SELECT s.id, s.name, s.phone, s.dateHired FROM Employee s WHERE  s.dateFired IS NULL")
    List<Employee> failedInSub();


}
