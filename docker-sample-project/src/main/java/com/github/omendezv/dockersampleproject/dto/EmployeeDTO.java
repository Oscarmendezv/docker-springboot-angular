package com.github.omendezv.dockersampleproject.dto;

import com.github.omendezv.dockersampleproject.model.entities.Employee;

public class EmployeeDTO {
    private Long employeeId;

    private String name;
    private String surname;
    private Long salary;
    private String company;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Employee convertToEntity() {
        Employee employee = new Employee();
        employee.setEmployeeId(this.employeeId);
        employee.setEmployer(this.company);
        employee.setName(this.name);
        employee.setSalary(this.salary);
        employee.setSurname(this.surname);

        return employee;
    }
}
