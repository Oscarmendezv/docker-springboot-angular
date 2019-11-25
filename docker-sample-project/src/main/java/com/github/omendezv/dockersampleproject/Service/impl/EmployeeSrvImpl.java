package com.github.omendezv.dockersampleproject.Service.impl;

import com.github.omendezv.dockersampleproject.Service.EmployeeSrv;
import com.github.omendezv.dockersampleproject.dto.EmployeeDTO;
import com.github.omendezv.dockersampleproject.model.entities.Employee;
import com.github.omendezv.dockersampleproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeSrvImpl implements EmployeeSrv {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDTO findEmployeeById(Long id) {
        return employeeRepository.findById(id).map(Employee::convertToDTO).orElseThrow(() -> new RuntimeException("Not employee with such id"));
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll().stream().map(Employee::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
