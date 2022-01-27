import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Admin } from '../model/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private UrlConnexion = 'http://localhost:8080/jeeProject/'

  constructor(private http:HttpClient) { }

  signIn(newAdmin: Admin): Observable<Admin> {
    return this.http.post<Admin>(this.UrlConnexion + 'login',newAdmin);
  }
  
  isLoggedIn(){
    if (localStorage.getItem('admin')){
      return JSON.parse(localStorage.getItem('admin') || '{}') ;
    }
    else return false;
  }

  signOut(){
    localStorage.clear();
  }
}
