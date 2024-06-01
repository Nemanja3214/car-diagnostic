import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BreakdownComponent } from './breakdown/breakdown.component';

export const routes: Routes = [
    {path: "breakdown",
    component: BreakdownComponent
    },
    {path: "login",
        component: LoginComponent
    }
  
];
