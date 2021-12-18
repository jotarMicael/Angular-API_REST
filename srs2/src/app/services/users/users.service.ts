import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { environment as env } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  firstname: string;
  surname: string
  email: string;
  date:string;
  constructor(private http: HttpClient) {

    this.getUserById().subscribe((data: any) => {
      this.firstname = data.nombre
      this.email = data.email
      this.date = data.fechaNacimiento
      this.surname = data.apellido      
    })
    

  }


  register(user: any) {


    return this.http.post(`${env.url}/user/create/`, user);
  }
  update(user: any) {


    return this.http.put(`${env.url}/user/update/` + JSON.parse(localStorage.getItem('currentUser') as string).userID, user, { headers: { 'token': JSON.parse(localStorage.getItem('currentUser') as string).token } });
  }

  getUserById() {



    return this.http.get(`${env.url}/user/find/` + JSON.parse(localStorage.getItem('currentUser') as string).userID, { headers: { 'token': JSON.parse(localStorage.getItem('currentUser') as string).token } });

  }

}
