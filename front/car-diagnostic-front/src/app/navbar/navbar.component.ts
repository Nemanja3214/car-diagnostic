import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';


@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterModule, CommonModule, HttpClientModule, JwtModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(private router: Router) {
  }

  // logout() {
  //   this.authService.logout();
  //   this.router.navigate(["login"]);
  // }

}
