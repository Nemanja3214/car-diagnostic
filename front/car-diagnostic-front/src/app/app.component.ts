import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from "./login/login.component";
import { BreakdownComponent } from "./breakdown/breakdown.component";
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { JwtModule } from '@auth0/angular-jwt';

import { CreateClientComponent } from './create-client/create-client.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { CheckServiceComponent } from './check-service/check-service.component';
import { LampCheckComponent } from './lamp-check/lamp-check.component';
@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, LoginComponent, FormsModule,CreateClientComponent, CreateCarComponent, BreakdownComponent, NavbarComponent,
        CommonModule, JwtModule, CheckServiceComponent, LampCheckComponent
    ]
})
export class AppComponent {
  title = 'car-diagnostic-front';
}
