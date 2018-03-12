package com.antonromanov.firstcrud.firstcrud.Services;
// This Project created by Anton Romanov (www.antonromanov.com) 27.02.2018 at 18:22
// Source URL - https://github.com/Zianwar/springboot-crud-demo/blob/master/src/main/java/com/ensat/services/ProductServiceImpl.java


import com.antonromanov.firstcrud.firstcrud.model.Employee;
import com.antonromanov.firstcrud.firstcrud.model.SelectQ;
import com.antonromanov.firstcrud.firstcrud.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Product service implement.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Autowired
    public void setProductRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Iterable<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> failedInSub() {
        return employeeRepository.failedInSub();
    }
}
