import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule, matSortAnimations } from '@angular/material/sort';
import { RepairmentService } from '../services/repairment.service';
import { HttpClientModule } from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from '../interceptor/token-interceptor';

@Component({
  selector: 'app-repairments',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatSortModule, HttpClientModule],
  providers:[RepairmentService, {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }, ],
  templateUrl: './repairments.component.html',
  styleUrl: './repairments.component.css'
})
export class RepairmentsComponent {

  car: Car = {
    id: 0,
    plate: '',
    yearOfProduction: '',
    model: '',
    km: 0,
    owner: ''
  };
  // allRepairments : RepairmentDTO[] = [{id: 1, action: "Promijenite akumulator.", "price": 200, discount: 10, mechanic: "Milan Maric"}];
  allRepairments : RepairmentDTO[] = [];
  allRepairmentsDisplayedColumns = ['action', 'price', 'discount', 'mechanic']

  constructor(private repairmentService: RepairmentService){
    console.log(repairmentService);
  }

  ngOnInit(): void {
    this.getCarInfo(1);
    this.getRepairments(1);
  }

  getCarInfo(id: number) {
    this.repairmentService.getCarInfo(id).subscribe({
      next: (value) => {
        console.log("succ\n" + JSON.stringify(value));
        this.car = value;
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  getRepairments(id: number) {
    this.repairmentService.getRepairmentsByCarId(id).subscribe({
      next: (value) => {
        console.log("succ\n" + JSON.stringify(value));
        this.allRepairments = value;
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

}

export interface Car{
  id: number,
  plate: string,
  yearOfProduction: string, 
  model: string,
  km: number,
  owner: string,
}


export interface RepairmentDTO{
  id: number,
  action: string,
  price: number, 
  discount: number,
  mechanic: string
}