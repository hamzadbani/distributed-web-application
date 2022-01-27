import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Job } from '../model/Job';

@Injectable({
  providedIn: 'root'
})
export class JobsService {
  private Url = 'http://localhost:8080/job/'
  constructor(private http:HttpClient) { }

  fetchAll():Observable<Job[]>{
    return this.http.get<Job[]>(this.Url + 'findall');    
  }
  addJob(newJob: Job):Observable<Job>{
    return this.http.post<Job>(this.Url + 'save',newJob);
  }
  deleteJob(JobId: String): Observable<object> {
    return this.http.delete<object>(this.Url + 'delete/'+ JobId);
  }
  update(JobId: String,job:Job):Observable<Job>{
    return this.http.put<Job>(this.Url + 'update/' + JobId, job);
  }

}
