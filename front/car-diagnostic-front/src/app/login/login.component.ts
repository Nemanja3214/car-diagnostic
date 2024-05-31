import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { AuthService } from './../services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule, MatFormField, MatFormFieldModule, ReactiveFormsModule, HttpClientModule
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
