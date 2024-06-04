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
import { TemplateService } from '../services/template.service';

@Component({
  selector: 'app-check-service',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, ReactiveFormsModule, MatInputModule, CommonModule, MatCardModule, MatSelectModule,
    HttpClientModule, JwtModule, MatButtonModule, MatCheckboxModule, MatTableModule],
  providers: [TemplateService],
  templateUrl: './check-service.component.html',
  styleUrl: './check-service.component.css'
})
export class CheckServiceComponent {
  dataSource: RepairmentDTO[] = [];
  displayedColumns: string[] = ['position', 'price', 'action'];

  createForm = new FormGroup({
    carId: new FormControl('', [Validators.required]),
    km: new FormControl('', [Validators.required]),
  });

  constructor(private templateService: TemplateService) {}

  check() {
    // this.submited = true;

    const params = {
      carId: this.createForm.value.carId,
      km: this.createForm.value.km,
    };

    if (this.createForm.valid) {
      this.templateService.checkService(params).subscribe({
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
