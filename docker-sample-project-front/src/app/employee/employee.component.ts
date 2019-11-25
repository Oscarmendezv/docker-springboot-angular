import { Component, OnInit } from '@angular/core';
import { EmployeeDataService } from '../service/data/employee-data.service';
import { Employee } from '../listemployees/listemployees.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  id:number
  employee:Employee

  constructor(private dataService: EmployeeDataService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id']
    this.employee = new Employee(this.id, 'Enter a name', 'Enter a surname', 'Enter a company', 0)

    if (this.id != -1){
      this.dataService.retrieveEmployee(this.id).subscribe(
        data => this.employee = data
      )
    }
  }

  saveEmployee(){
    if (this.id == -1){
      this.dataService.createEmployee(this.employee).subscribe(
        data => this.router.navigate(['employees'])
      )
    } else {
      this.dataService.updateEmployee(this.id, this.employee).subscribe(
        data => {
          this.router.navigate(['employees'])
        }
      )
    }
  }

}
