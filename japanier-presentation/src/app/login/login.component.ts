import { Component } from '@angular/core';

import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { LoginService } from './login.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  providers: [LoginService]
})
export class LoginComponent {
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required/*, 
      Validators.pattern('^[\p{L}0-9._%+-]+@[\p{L}0-9.-]+\.[a-zA-Z]{2,}$')*/]),
    password: new FormControl('', [Validators.required, Validators.minLength(8), 
      Validators.pattern('^(?=.*[a-z])(?=.*[A-Z]).*$'), 
      Validators.pattern('^(?=.*\\d).*$'), 
      Validators.pattern('^(?=.*[\\W_]).*$')])
  });

  constructor(private service: LoginService, private formBuilder: FormBuilder){}

  onSubmit() {
    console.log('Your form data : ', this.loginForm.value );
    this.loginForm.markAllAsTouched();
    const form = this.loginForm.value;
    if(!form.email || !form.password) {
      return;
    }
    this.service.login(form.email, form.password);
  }

  get email(){
    return this.loginForm.get('email');
  }

  get password(){
   return this.loginForm.get('password');
  }

}