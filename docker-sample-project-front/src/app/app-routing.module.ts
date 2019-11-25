import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { ListemployeesComponent } from './listemployees/listemployees.component';
import { EmployeeComponent } from './employee/employee.component';
import { ErrorComponent } from './error/error.component';

// welcome
const routes: Routes = [
  { path:'', component: WelcomeComponent},
  { path:'employees', component: ListemployeesComponent},
  { path:'employees/:id', component: EmployeeComponent},
  { path:'**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
