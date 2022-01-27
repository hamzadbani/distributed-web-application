import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { JobsComponent } from './components/jobs/jobs.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path:"home",component:HomeComponent},
  {path:"login",component:LoginComponent},
  {path:"jobs",component:JobsComponent},
  {path:"",redirectTo:"home",pathMatch:"full"},     
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
