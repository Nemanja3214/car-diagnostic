import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Chart, ChartType } from 'chart.js/auto';
import { BreakdownService, GraphData } from '../services/breakdown.service';
import { MatFormField,  MatFormFieldModule, MatFormFieldControl } from '@angular/material/form-field';
import { HttpClientModule } from '@angular/common/http';
import {MatSelectModule} from '@angular/material/select';
import { BaseChartDirective } from 'ng2-charts';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Car, CarService } from '../services/car.service';
import { Client, ClientService } from '../services/client.service';
import { RepairmentDTO } from '../repairments/repairments.component';
import {MatTableModule} from '@angular/material/table';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';


@Component({
  selector: 'app-check-battery',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, ReactiveFormsModule,BaseChartDirective, CommonModule,MatSelectModule,MatButtonModule,
    HttpClientModule, MatTableModule,MatProgressSpinnerModule],
  templateUrl: './check-battery.component.html',
  providers: [BreakdownService, ClientService, CarService],
  styleUrl: './check-battery.component.css'
})
export class CheckBatteryComponent implements OnInit{

  loading: boolean = false;

  data: GraphData[] = [];
  chartData: {x: number, y: number}[] = [];
  carId: number | null = null;
  caseScenario : number = 3;

  chooseCarForm = new FormGroup({
    car: new FormControl<Car | null>(null, [Validators.required]),
  });
  availableElectricCars: Car[] = [];
  availableClients: Client[] = [];


  displayedColumns: string[] = ['position', 'price', 'action'];
  repairments: RepairmentDTO[] = [];

  constructor(private breakdownService: BreakdownService, private carService: CarService, private clientService: ClientService) { }
  ngOnInit(): void {
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

  public lineChartData:Array<any> = [
  ];
  public lineChartLabels:Array<any> = [];
  public lineChartOptions:any = {
    responsive: true
  };
  public lineChartType:ChartType = 'line';

  cmpFn(a: GraphData, b: GraphData){
    if(a.startTime > b.startTime)
    return 1;
    else if(a.startTime < b.startTime)
    return -1;
    return 0;
  }
 
  randomIntFromInterval(min: number, max: number) { // min and max included 
    return Math.floor(Math.random() * (max - min + 1) + min);
  }
  
  checkBattery(){
    if(!this.chooseCarForm.valid)
      return;
      this.loading = true;
    this.carId = this.chooseCarForm.value!.car!.id!;
    this.breakdownService.checkBattery(this.chooseCarForm.value!.car!.id!, this.caseScenario) .subscribe(
      (response) => {
        // Handle the successful response
        // this.data = response.currentReadings;
        this.loading = false;
        response.currentReadings.sort(this.cmpFn);
        this.lineChartData = [];
        this.lineChartLabels = [];
        this.lineChartData.push({data: response.currentReadings.map(l => l.currentCharge), label: "Charge"});
        this.lineChartData.push({data: response.currentReadings.map(l => l.value), label: "Current"});
        this.lineChartData.push({data: response.currentReadings.map(l => l.currentSOC), label: "SOC"});
        this.lineChartLabels = response.currentReadings.map(l =>new Date(l.startTime)).map(d => d.toLocaleTimeString() + " " + d.toLocaleDateString());

        this.repairments = response.repairments;
      },
      (error) => {
        console.error('Error handler:', error);
      }
    );
  }

  onClientChange(event: any) {
    // Update the selected option when the selection changes
    let selectedOption = event.value;
    this.carService.getElectricByClient(event.value.id) .subscribe(
      (response) => {
        // Handle the successful response
        this.availableElectricCars = response
      },
      (error) => {
        // This block will only execute if catchError is used
        console.error('Error handler:', error);
      }
    );
  }

  
}
