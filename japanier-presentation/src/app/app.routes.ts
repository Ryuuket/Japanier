import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthenticationComponent } from './registration/registration.component';

export const routes: Routes = [
    {path:'', component: HomeComponent},
    {path:'authentication', component: AuthenticationComponent}
];
