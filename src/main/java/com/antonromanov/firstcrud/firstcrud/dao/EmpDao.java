package com.antonromanov.firstcrud.firstcrud.dao;

import com.antonromanov.firstcrud.firstcrud.model.Employee;

import java.util.List;

public interface EmpDao {


    public void hire(Employee employee);
    public void fire(int id);
    public Employee getEmployeeById(int id);
    public List<Employee> listEmpls();






    }
