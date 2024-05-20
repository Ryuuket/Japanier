import { Component } from '@angular/core';

import { Login } from './login.interface';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { log } from 'console';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [ReactiveFormsModule]
})
export class LoginComponent {

  loginForm = new FormGroup({
    email: new FormControl (''),
    password: new FormControl('')
});

  onSubmit() {
    console.log('Your form data : ', this.loginForm.value );
  }

  getEmail(){
    return this.loginForm.get('email');
  }

  getPassword(){
   return this.loginForm.get('password');
  }

}