import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BreakdownComponent } from './breakdown/breakdown.component';
import { RepairmentsComponent } from './repairments/repairments.component';
import { ModifyTemplateComponent } from './modify-template/modify-template.component';
import { LandingPageComponent } from './landing-page/landing-page.component';

import { CreateClientComponent } from './create-client/create-client.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { CheckServiceComponent } from './check-service/check-service.component';

import { CheckBatteryComponent } from './check-battery/check-battery.component';
import { LampCheckComponent } from './lamp-check/lamp-check.component';
export const routes: Routes = [
    {path: "breakdown",
    component: BreakdownComponent
    },
    {path: "login",
        component: LoginComponent
    },
    {path: "repairments/:id",
        component: RepairmentsComponent
    },
    {path: "template",
        component: ModifyTemplateComponent
    },
    {path: "landing",
        component: LandingPageComponent
    },
    {path: "client-create",
        component: CreateClientComponent
    },

    {path: "service-check",
        component: CheckServiceComponent
    },

    {path: "car-create",
    component: CreateCarComponent
    },
{path: "check-battery",
        component: CheckBatteryComponent
    },

    {path: "check-lamps",
        component: LampCheckComponent
    },
    {path: "**",
        component: LandingPageComponent
    },
];
