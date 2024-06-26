import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { LessonsListComponent } from './lessons-list/lessons-list.component';

export const routes: Routes = [
    {path:'', component: HomeComponent},
    {path:'register', component: RegistrationComponent},
    {path:'login', component: LoginComponent},
    {path:'lessons', component: LessonsListComponent}
];
