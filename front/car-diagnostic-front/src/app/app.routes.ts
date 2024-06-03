import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BreakdownComponent } from './breakdown/breakdown.component';
import { RepairmentsComponent } from './repairments/repairments.component';
import { CreateClientComponent } from './create-client/create-client.component';
export const routes: Routes = [
    {path: "breakdown",
    component: BreakdownComponent
    },
    {path: "login",
        component: LoginComponent
    },
 
    {path: "repairments",
        component: RepairmentsComponent
    },

    {path: "client-create",
        component: CreateClientComponent
    },
];
