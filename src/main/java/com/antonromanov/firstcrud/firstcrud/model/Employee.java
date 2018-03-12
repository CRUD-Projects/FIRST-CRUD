package com.antonromanov.firstcrud.firstcrud.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "date_hired")
    private Date dateHired;

    @Column(name = "date_fired")
    private Date dateFired;

    public Employee() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public Date getDateFired() {
        return dateFired;
    }

    public void setDateFired(Date dateFired) {
        this.dateFired = dateFired;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        if (dateHired != null ? !dateHired.equals(employee.dateHired) : employee.dateHired != null) return false;
        if (dateFired != null ? !dateFired.equals(employee.dateFired) : employee.dateFired != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (dateHired != null ? dateHired.hashCode() : 0);
        result = 31 * result + (dateFired != null ? dateFired.hashCode() : 0);
        return result;
    }
}
