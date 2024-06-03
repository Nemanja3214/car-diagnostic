import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BreakdownComponent } from './breakdown/breakdown.component';
import { RepairmentsComponent } from './repairments/repairments.component';
import { ModifyTemplateComponent } from './modify-template/modify-template.component';

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
    {path: "template",
        component: ModifyTemplateComponent
    },
];
