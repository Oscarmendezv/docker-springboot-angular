package com.github.omendezv.dockersampleproject.Service;

import com.github.omendezv.dockersampleproject.dto.EmployeeDTO;
import com.github.omendezv.dockersampleproject.model.entities.Employee;

import java.util.List;

public interface EmployeeSrv {

    EmployeeDTO findEmployeeById(Long id);
    List<EmployeeDTO> findAllEmployees();
    void createEmployee(Employee employee);
    void deleteEmployee(Long id);
    void updateEmployee(Employee employee);
}
