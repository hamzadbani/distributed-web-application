import { Component, OnInit } from '@angular/core';
import { JobsService } from 'src/app/services/jobs.service';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';
import { Job } from 'src/app/model/Job';
import Swal from 'sweetalert2';
import { LoginComponent } from '../login/login.component';
@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {
  listOfJobs !: Job[];
  newJob: Job = new Job();
  JobToEdit: Job = new Job();
  editIndex !:number;
  logged : boolean = false;
  searchTerm !: string;
  variableTest !:any;
  constructor(private jobService:JobsService,private adminService:AdminService, private router:Router) { }

  ngOnInit(): void {
    this.jobService.fetchAll().subscribe(
      (response : Job[])=>{
        this.listOfJobs = response
        console.log(response);
      }
    )
    if (!this.adminService.isLoggedIn()){
      this.router.navigate(['/login']);
       // window.location.href="/login";
      //  console.log('blan');
     }    
    if(this.adminService.isLoggedIn()){
      this.logged = true;
     }
     else{
      this.logged = false;
     }
  }
  alertConfirmation(){
    Swal.fire({
      title: 'Are you sure?',
      text: 'Your Action cannot be rollback.',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, go ahead.',
      cancelButtonText: 'No, let me think again'
    }).then((result) => {
      if (result.value) {
        Swal.fire(
          'Done!',
          'Action performed successfully.',
          'success'
        ).then((result)=>{
        if(result.value){
            window.location.href="/jobs";
        }
        })
      }
      else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelled',
          'Performed action record present in cloud and databstore.)',
          'error'
        )
      }
    })
  }
  AddConfirmation(){
        Swal.fire(
          'Done!',
          'Action performed successfully.',
          'success'
        ).then((result)=>{
        if(result.value){
            window.location.href="/jobs";
      }
    })
  }  

  editJob(index: number) {
    this.JobToEdit.id = this.listOfJobs[index].id;
    this.JobToEdit.title = this.listOfJobs[index].title;
    this.JobToEdit.company = this.listOfJobs[index].company;
    this.JobToEdit.location = this.listOfJobs[index].location;
    this.JobToEdit.type = this.listOfJobs[index].type;
    this.JobToEdit.level = this.listOfJobs[index].level;
    this.JobToEdit.yearsExp = this.listOfJobs[index].yearsExp;
    this.JobToEdit.country = this.listOfJobs[index].country;
    this.JobToEdit.skills = this.listOfJobs[index].skills;
    this.editIndex = index;
  }
  updateJob() {
    this.jobService.update( this.JobToEdit.id ,this.JobToEdit).subscribe();
      window.location.href="/jobs"
    }
  
  confirmDelete(id: String){
  this.jobService.deleteJob(id).subscribe();
  this.alertConfirmation();
  }

formUpdateIsValid(){
    return (this.JobToEdit.company.length !== 0 && this.JobToEdit.country.length !== 0 
      && this.JobToEdit.level.length !== 0 && this.JobToEdit.location.length !== 0
      && this.JobToEdit.skills.length !== 0 && this.JobToEdit.title.length !== 0
      && this.JobToEdit.type.length !== 0 && this.JobToEdit.yearsExp.length !== 0);
  }
formIsValid(){
    return (this.newJob.company.length !== 0 && this.newJob.country.length !== 0 
      && this.newJob.level.length !== 0 && this.newJob.location.length !== 0
      && this.newJob.skills.length !== 0 && this.newJob.title.length !== 0
      && this.newJob.type.length !== 0 && this.newJob.yearsExp.length !== 0);
  }
  saveJob(){
    this.jobService.addJob(this.newJob).subscribe(
      (response) =>{
        console.log(response);
        //window.location.href="/jobs"
        this.AddConfirmation();
      },(error)=>{
        console.log(error)
      }
    )
  }

  
  // findJobs(){
  //   this.jobService.findJob(this.searchTerm).subscribe(
  //     (response: Job[]) => {
  //       console.log(response)
  //       this.listOfJobs = response;
  //       this.searchTerm = '';
  //     }
  //   );
  // }
  logout(){
    this.adminService.signOut();
    this.logged = false;
    this.router.navigate(['/home']);
   }
}
