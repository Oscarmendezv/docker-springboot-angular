import { Component, OnInit } from '@angular/core';
import { EmployeeDataService } from '../service/data/employee-data.service';
import { Router } from '@angular/router';

export class Employee {
  constructor(
    public id: number,
    public name: string,
    public surname: string,
    public company: string,
    public salary: number
  ){}
}

@Component({
  selector: 'app-listemployees',
  templateUrl: './listemployees.component.html',
  styleUrls: ['./listemployees.component.css']
})
export class ListemployeesComponent implements OnInit {

  employees = []
  message

  constructor(private employeeService: EmployeeDataService,
    private router: Router) { }

  ngOnInit() {
    this.loadEmployees();
  }

  loadEmployees(){
    this.employeeService.retrieveAllEmployees().subscribe(
      response=> {
        this.employees=response;
      }
    );
  }

  deleteEmployee(id){
    this.employeeService.deleteEmployee(id).subscribe(
      response => {
        this.message = `Delete successful for Employee ${id}`;
        this.loadEmployees();
      }
    );
  }

  updateEmployee(id){
    this.router.navigate(['employees',id])
  }

  addEmployee(){
    this.router.navigate(['employees',-1])
  }

}
