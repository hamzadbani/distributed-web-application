import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/Admin';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  newAdmin : Admin = new Admin();
  constructor(private adminService:AdminService, private router:Router) { }

  ngOnInit(): void {
    this.newAdmin.email = "";
    this.newAdmin.password = "";

    if (this.adminService.isLoggedIn()){
      this.router.navigate(['/home']);
     } 
  }

  formIsValid(){
    return (this.newAdmin.email !== null && this.newAdmin.password !== null)
      && (this.newAdmin.email.length !== 0 && this.newAdmin.password.length !== 0);
  }

  submitForm(){
    this.adminService.signIn(this.newAdmin).subscribe((response) => {

      this.newAdmin.email = "";
      this.newAdmin.password = "";

      localStorage.setItem('admin', JSON.stringify(response));
  
      
      window.location.href="/jobs";

    }, (error) => {
       console.log(error);
      alert("User name or password is incorrect");
    }
    )
  }
}
