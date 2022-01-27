import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  logged : boolean = false;
  constructor(private adminService:AdminService, private router:Router) { }

  ngOnInit(): void {
    if(this.adminService.isLoggedIn()){
      this.logged = true;
     }
     else{
      this.logged = false;
     }
  }
  logout(){
    this.adminService.signOut();
    this.logged = false;
    this.router.navigate(['/home']);
   }
}

  

  
  
  

  

