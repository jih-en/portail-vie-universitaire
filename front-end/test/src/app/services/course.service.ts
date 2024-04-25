import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class CourseService {



  constructor(private http:HttpClient) { }
  getCources():Observable<any>{

      const headers = new HttpHeaders().set('Content-Type', 'application/json');
      return this.http.get('http://localhost:8084/Cours', { headers: headers });
    }
   
  
  
  add(formData: FormData){
    
    return this.http.post('http://localhost:8084/upload',formData)

  }
  editCourse(data:any){
    const formData = new FormData();
    formData.append('descrip', data.descrip);
    formData.append('createur', data.createur);
    formData.append('name', data.name);

    return this.http.post('http://localhost:8084/update/'+data.id,formData)

  }
  delete(id:any){
    return this.http.delete('http://localhost:8084/delete/'+id)
  }
}
