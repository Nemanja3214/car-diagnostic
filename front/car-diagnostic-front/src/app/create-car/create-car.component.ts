import { Component, OnInit } from '@angular/core';
import { CarModel, CarService, CreateCar, CreateElectricCar, CreateGasCar, plateValidator } from '../services/car.service';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField,  MatFormFieldModule, MatFormFieldControl, MatFormFieldAppearance } from '@angular/material/form-field';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { Client, ClientService } from '../services/client.service';
import { SnackbarService } from '../services/snackbar.service';
import {MatSelectModule} from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatButtonToggleModule} from '@angular/material/button-toggle';

@Component({
  selector: 'app-create-car',
  standalone: true,
  imports: [MatInputModule, MatButtonModule, FormsModule, MatFormFieldModule, ReactiveFormsModule, HttpClientModule,
    MatCardModule, MatSelectModule, CommonModule, MatButtonToggleModule],
  templateUrl: './create-car.component.html',
  providers:[CarService, ClientService],
  styleUrl: './create-car.component.css'
})
export class CreateCarComponent implements OnInit{
logChanges() {
  console.log(this.carForm.value);
}
selectedType: string = "electric";
availableCarModels: CarModel[] = [];

toggleChanged() {
        // console.log("ASD");
      if (this.selectedType === 'electric') {
        this.carForm.get('nominalMaxVoltage')!.setValidators([Validators.required, Validators.min(0)]);
        this.carForm.get('nominalMaxVoltage')!.enable(); // Enable if electric

        this.carForm.get('nominalMaxCharge')!.setValidators([Validators.required, Validators.min(0)]);
        this.carForm.get('nominalMaxCharge')!.enable(); // Enable if electric
      } else {
        this.carForm.get('nominalMaxVoltage')!.clearValidators();
        this.carForm.get('nominalMaxVoltage')!.disable();

        this.carForm.get('nominalMaxCharge')!.clearValidators();
        this.carForm.get('nominalMaxCharge')!.disable();
      }
      this.carForm.get('nominalMaxVoltage')!.updateValueAndValidity(); // Update validity
      this.carForm.get('nominalMaxCharge')!.updateValueAndValidity(); // Update validity
      // console.log("VALIDATORS " + this.carForm.get('nominalMaxVoltage')!.validator)
}

  appearance: MatFormFieldAppearance = 'outline';

  carForm: FormGroup = this.fb.group({
    plate: ['', [Validators.required, plateValidator()]],
    yearOfProduction: ['', [Validators.required, Validators.min(1960)]],
    km: [0, [Validators.required, Validators.min(0)]],
    owner: new FormControl<Client | null>(null, [Validators.required]),
    model: new FormControl<CarModel | null>(null, Validators.required),
    nominalMaxCharge: [null, [Validators.min(0.00000000000001), Validators.required]],
    nominalMaxVoltage: [null, [Validators.min(0.1), Validators.required]],
  });
  availableClients: Client[] = [];
  isChecked: any;

  constructor(private fb: FormBuilder, private clientService: ClientService, private carService: CarService,
     private snackbarService: SnackbarService) { }

  ngOnInit(): void {

    this.clientService.getClients() .subscribe(
      (response) => {
        this.availableClients = response
      },
      (error) => {
        console.error('Error handler:', error);
      }
    );

    this.carService.getCarModels() .subscribe(
      (response) => {
        this.availableCarModels = response
      },
      (error) => {
        console.error('Error handler:', error);
      }
    );

  }

  onSubmit() {
    if (!this.carForm.valid) {
      return;
    }
    if(this.selectedType == 'electric'){
      const dto: CreateElectricCar = {
        plate: this.carForm.value.plate!,
        yearOfProduction: this.carForm.value.yearOfProduction!,
        km: this.carForm.value.km!,
        ownerId: this.carForm.value.owner.id,
        carModelId: this.carForm.value.model.id,
        nominalMaxCharge: this.carForm.value.nominalMaxCharge,
        nominalMaxVoltage: this.carForm.value.nominalMaxVoltage
      };
      console.log(dto);
      this.carService.createElectricCar(dto).subscribe(
        (response) => {
          console.log(response);
          this.snackbarService.showSnackbar("Success");
        },
        (error) => {
          // This block will only execute if catchError is used
          console.error('Error handler:', error);
        }
      );  
    }else{
      {
        const dto: CreateGasCar = {
          plate: this.carForm.value.plate!,
          yearOfProduction: this.carForm.value.yearOfProduction!,
          km: this.carForm.value.km!,
          ownerId: this.carForm.value.owner.id,
          carModelId: this.carForm.value.model.id,
        };
        console.log(dto);
        this.carService.createGasCar(dto).subscribe(
          (response) => {
            console.log(response);
            this.snackbarService.showSnackbar("Success");
          },
          (error) => {
            // This block will only execute if catchError is used
            console.error('Error handler:', error);
          }
        );  
      }
    }


  };

  


}
