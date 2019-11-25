import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from 'src/app/listemployees/listemployees.component';
import { EMPLOYEE_JPA_API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDataService {

  constructor(private httpClient: HttpClient) { }

  retrieveAllEmployees(){
    return this.httpClient.get<Employee[]>(`${EMPLOYEE_JPA_API_URL}`);
  }

  retrieveEmployee(id){
    return this.httpClient.get<Employee>(`${EMPLOYEE_JPA_API_URL}/${id}`);
  }

  updateEmployee(id, employee){
    return this.httpClient.put(`${EMPLOYEE_JPA_API_URL}/${id}`, employee);
  }

  createEmployee(employee){
    return this.httpClient.post(`${EMPLOYEE_JPA_API_URL}`, employee);
  }

  deleteEmployee(id){
    return this.httpClient.delete(`${EMPLOYEE_JPA_API_URL}/${id}`);
  }
}
