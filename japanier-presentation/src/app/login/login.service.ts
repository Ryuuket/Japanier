import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { tap } from "rxjs";
import { Login } from "./login.interface";

@Injectable({
    providedIn: 'root'
  })
  export class LoginService {
  
    private apiUrl = 'http://localhost:8080/users/login';
  
    constructor(private http: HttpClient) { }

    async login(email: string, password: string){
        const headers = new HttpHeaders ({'content-type': 'application-json'});
        console.log(headers);
        return this.http.post<Login>(
            this.apiUrl, JSON.stringify({email, password}), {'headers': headers, withCredentials: true}
        ).subscribe({
            next: () => {
                console.log('logged in')
            }
        })
    }
}