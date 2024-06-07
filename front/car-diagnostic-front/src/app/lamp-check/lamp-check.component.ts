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
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatTableModule} from '@angular/material/table';
import {
  MatSnackBar,
  MatSnackBarAction,
  MatSnackBarActions,
  MatSnackBarLabel,
  MatSnackBarRef,
} from '@angular/material/snack-bar';
import { RepairmentDTO } from '../repairments/repairments.component';
import { LampService } from '../services/lamp.service';
@Component({
  selector: 'app-lamp-check',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, ReactiveFormsModule, MatInputModule, CommonModule, MatCardModule, MatSelectModule,
    HttpClientModule, JwtModule, MatButtonModule, MatCheckboxModule, MatTableModule],
  providers: [LampService],

  templateUrl: './lamp-check.component.html',
  styleUrl: './lamp-check.component.css'
})
export class LampCheckComponent {

  constructor(private lampService: LampService) {}

  dataSource: RepairmentDTO[] = [];
  displayedColumns: string[] = ['position', 'price', 'action'];

  createForm = new FormGroup({
    lamp: new FormControl('', [Validators.required]),
    carId: new FormControl('', [Validators.required]),
  });

  availableItems: string[] = ['Service', 'Transmission', 'Oil', 'Engine', 'Small Service', 'Big Service', 'Transmission Service', 'Clutch Service', 'Clutch']; 
  lamps: string[] = [];
  addLamp() {
    if (this.createForm.valid){
      if (this.createForm.value.lamp != null)
        this.lamps.push(this.createForm.value.lamp);
      console.log(this.lamps);
    }
  }
  
  sendLamps() {
    if (this.lamps.length == 0) {
      console.log("PRAZNOO")
      return
    }
    let forSending: Lamp[] = [];
    forSending.push({
      lampKind: 'Root',
      causedByLamp: 'Malfunction',
      plate: ''
    })
    let currentAnc = 'Root';
    this.lamps.forEach((l: string) => {
      forSending.push({lampKind: l, causedByLamp: currentAnc, plate: ''})
      currentAnc=l;
    })
    console.log(forSending);

    if (this.createForm.value.carId) {
      this.lampService.checkLamps(forSending, this.createForm.value.carId).subscribe({
        next: (result) => {
          console.log(result);
          this.dataSource = result;
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

}

export interface Lamp {
  lampKind: string,
  causedByLamp: string,
  plate: string
}
