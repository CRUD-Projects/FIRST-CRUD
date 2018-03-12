package com.antonromanov.firstcrud.firstcrud.Services;

import com.antonromanov.firstcrud.firstcrud.model.Employee;


import java.util.List;

public interface EmployeeService {

    Iterable<Employee> listAllEmployees();

    public List<Employee> failedInSub();

}
