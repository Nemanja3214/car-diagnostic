import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from "./login/login.component";
import { BreakdownComponent } from "./breakdown/breakdown.component";
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CreateClientComponent } from './create-client/create-client.component';
import { CreateCarComponent } from './create-car/create-car.component';
@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, LoginComponent, FormsModule,CreateClientComponent, CreateCarComponent, BreakdownComponent, ]
})
export class AppComponent {
  title = 'car-diagnostic-front';
}
