import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
  export class LoginService {
  
    private apiUrl = 'https://localhost:8080'; // Replace with your backend API URL
  
    constructor(private http: HttpClient) { }
}