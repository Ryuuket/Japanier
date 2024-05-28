import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Lesson} from "./lessons-list.interface";

@Injectable({
    providedIn: 'root'
  })
  export class LessonsListService {
  
    private apiUrl = 'http://localhost:8080/videoLessons/default';
  
    constructor(private http: HttpClient) { }

     getList(){
        console.log('get list')
        return this.http.get<Lesson[]>(
            this.apiUrl, { withCredentials: true }   
        )
    }
}