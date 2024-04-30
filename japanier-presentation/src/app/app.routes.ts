import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthenticationComponent } from './authentication/authentication.component';

export const routes: Routes = [
    {path:'', component: HomeComponent},
    {path:'authentication', component: AuthenticationComponent}
];
