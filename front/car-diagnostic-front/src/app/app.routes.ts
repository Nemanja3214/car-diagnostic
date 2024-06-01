import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RepairmentsComponent } from './repairments/repairments.component';

export const routes: Routes = [
    {path: "login",
        component: LoginComponent
    },
    {path: "repairments",
        component: RepairmentsComponent
    },
];
