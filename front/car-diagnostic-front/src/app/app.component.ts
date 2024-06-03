import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from "./login/login.component";
import { BreakdownComponent } from "./breakdown/breakdown.component";
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { JwtModule } from '@auth0/angular-jwt';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, LoginComponent, FormsModule, BreakdownComponent, NavbarComponent, CommonModule, JwtModule]
})
export class AppComponent {
  title = 'car-diagnostic-front';
}
