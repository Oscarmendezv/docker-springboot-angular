package com.github.omendezv.dockersampleproject.controller;

import com.github.omendezv.dockersampleproject.Service.EmployeeSrv;
import com.github.omendezv.dockersampleproject.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeCtrl {

    @Autowired EmployeeSrv employeeSrv;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public EmployeeDTO findEmployeeById(@PathVariable Long id) {

        return employeeSrv.findEmployeeById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public List<EmployeeDTO> findAllEmployees() {
        return employeeSrv.findAllEmployees();
    }

    @PostMapping
    @CrossOrigin
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeSrv.createEmployee(Optional.ofNullable(employeeDTO)
                .map(EmployeeDTO::convertToEntity)
                .orElseThrow(() ->new RuntimeException("Invalid employee")));
    }

    @DeleteMapping(path = "/{id}")
    @CrossOrigin
    public void deleteEmployee(@PathVariable Long id) {
        employeeSrv.deleteEmployee(id);
    }

    @PutMapping(path = "/{id}")
    @CrossOrigin
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeSrv.updateEmployee(Optional.ofNullable(employeeDTO)
                .map(EmployeeDTO::convertToEntity)
                .orElseThrow(() ->new RuntimeException("Invalid employee")));
    }
}
