import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse } from '@angular/common/http';
import { environment as env } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }


  getService(id:number){

    return this.http.get(`${env.url}/service/`+ id,{ headers: { 'token': JSON.parse(localStorage.getItem('currentUser') as string).token } })
  }

  updateService(service:any){
    return this.http.put(`${env.url}/service/update/`+service.id,service, { headers: { 'token': JSON.parse(localStorage.getItem('currentUser') as string).token } })
  }

  getServicesByUser(){

    return this.http.get(`${env.url}/service/find/`+ JSON.parse(localStorage.getItem('currentUser') as string).userID,{ headers: { 'token': JSON.parse(localStorage.getItem('currentUser') as string).token } })
  }

  addService(service:any){

    return this.http.post(`${env.url}/service/create`,service,{ headers: { 'token': JSON.parse(localStorage.getItem('currentUser') as string).token } });
  }

  delete(id:number){
    return this.http.get(`${env.url}/service/delete/`+ id, { headers: { 'token': JSON.parse(localStorage.getItem('currentUser') as string).token } })
  }


}
