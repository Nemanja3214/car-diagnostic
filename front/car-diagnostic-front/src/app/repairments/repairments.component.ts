import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule, matSortAnimations } from '@angular/material/sort';

@Component({
  selector: 'app-repairments',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatSortModule],
  templateUrl: './repairments.component.html',
  styleUrl: './repairments.component.css'
})
export class RepairmentsComponent {

  car: Car = {id: 1, plate:"NS234212", yearOfProduction:"2000", model: "AUDI A4", km: 322322};
  allRepairments : RepairmentDTO[] = [{id: 1, action: "Promijenite akumulator.", "price": 200, discount: 10, mechanic: "Milan Maric"}];
  allRepairmentsDisplayedColumns = ['action', 'price', 'discount', 'mechanic']


}

export interface Car{
  id: number,
  plate: string,
  yearOfProduction: string, 
  model: string,
  km: number
}


export interface RepairmentDTO{
  id: number,
  action: string,
  price: number, 
  discount: number,
  mechanic: string
}