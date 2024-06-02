import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField,  MatFormFieldModule, MatFormFieldControl } from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { BreakdownService, CreateBreakdown } from './../services/breakdown.service';
import {Client, ClientService} from "../services/client.service"
import {SnackbarService} from "../services/snackbar.service"
import {Car, CarService} from "../services/car.service"
import { HttpClientModule } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';
import { MatButtonModule } from '@angular/material/button';
import {
  MatSnackBar,
  MatSnackBarAction,
  MatSnackBarActions,
  MatSnackBarLabel,
  MatSnackBarRef,
} from '@angular/material/snack-bar';

@Component({
  selector: 'app-breakdown',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, ReactiveFormsModule, MatInputModule, CommonModule, MatCardModule, MatSelectModule,
    HttpClientModule, JwtModule, MatButtonModule],
  templateUrl: './breakdown.component.html',
  providers:[BreakdownService, ClientService, CarService],
  styleUrl: './breakdown.component.css'
})
export class BreakdownComponent implements OnInit{
  availableCars: Car[] = [];
  availableClients: Client[] = [];

  createForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    symptoms: new FormControl([], [Validators.required]),
    car: new FormControl<Car | null>(null, [Validators.required]),
  });




  constructor(private breakdownService: BreakdownService, private clientService: ClientService, private carService: CarService,
    private snackBarService: SnackbarService){
  }


  ngOnInit(): void {
    this.breakdownService.getSymptoms() .subscribe(
      (response) => {
        // Handle the successful response
        this.availableItems = response
      },
      (error) => {
        // This block will only execute if catchError is used
        console.error('Error handler:', error);
      }
    );

    this.clientService.getClients() .subscribe(
      (response) => {
        // Handle the successful response
        this.availableClients = response
      },
      (error) => {
        // This block will only execute if catchError is used
        console.error('Error handler:', error);
      }
    );
  }


  availableItems: string[] = []; // Sample available items

  createBreakdown(){
    if (!this.createForm.valid) {
      return;
    }
    const dto: CreateBreakdown = {
      name: this.createForm.value.name!,
      symptoms: this.createForm.value.symptoms!,
      carId: this.createForm.value.car!.id
    };
    console.log(dto);
    this.breakdownService.createBreakdown(dto).subscribe(
      (response) => {
        console.log(response);
        this.snackBarService.showSnackbar("Success");
      },
      (error) => {
        // This block will only execute if catchError is used
        console.error('Error handler:', error);
      }
    );
  }

  onClientChange(event: any) {
    // Update the selected option when the selection changes
    let selectedOption = event.value;
    this.carService.getByClient(event.value.id) .subscribe(
      (response) => {
        // Handle the successful response
        this.availableCars = response
      },
      (error) => {
        // This block will only execute if catchError is used
        console.error('Error handler:', error);
      }
    );
  }

  // onSubmit() {
  //   // this.submited = true;

  //   const credentials = {
  //     email: this.loginForm.value.email,
  //     password: this.loginForm.value.password
  //   };

  //   this.breakdownService.create(credentials).subscribe({
  //     next: (result) => {
  //       this.processLogin(result);
  //     },
  //       error: (error) => {
  //       console.log(error);
  //       console.log("tu")
  //       console.log(error.error)
  //     //   this.snackBar.open("Bad credentials. Please try again!", "", {
  //     //     duration: 2700, panelClass: ['snack-bar-server-error']
  //     //  });
  //     },
  //   });
  // }
}
