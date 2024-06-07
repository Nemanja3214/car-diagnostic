import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField, MatFormFieldModule, MatFormFieldControl } from '@angular/material/form-field';
import { AuthService } from './../services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import { JwtModule, JwtHelperService, JWT_OPTIONS } from '@auth0/angular-jwt';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';




@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule, MatFormFieldModule, ReactiveFormsModule, HttpClientModule, MatInputModule, CommonModule, JwtModule
  ],
  providers:[AuthService],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private authService: AuthService){
    console.log(authService);
  }

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
  });

  onSubmit() {
    // this.submited = true;

    const credentials = {
      email: this.loginForm.value.email,
      password: this.loginForm.value.password
    };

    if (this.loginForm.valid) {
      this.authService.login(credentials).subscribe({
        next: (result) => {
          this.processLogin(result);
        },
         error: (error) => {
          console.log(error);
          console.log("tu")
          console.log(error.error)
        //   this.snackBar.open("Bad credentials. Please try again!", "", {
        //     duration: 2700, panelClass: ['snack-bar-server-error']
        //  });
        },
      });
    }
  }

  processLogin(result: any) {
    localStorage.setItem('user', JSON.stringify(result.accessToken));
    localStorage.setItem('refreshToken', JSON.stringify(result.refreshToken));
    this.authService.setUser();
    console.log(this.authService.getUser());
  }

}
