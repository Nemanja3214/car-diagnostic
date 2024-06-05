import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { RepairmentService } from '../services/repairment.service';
import { CarService } from '../services/car.service';
import { TokenInterceptor } from '../interceptor/token-interceptor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatSortModule, HttpClientModule],
  providers:[CarService, {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }, ],
  templateUrl: './landing-page.component.html',
  styleUrl: './landing-page.component.css'
})
export class LandingPageComponent {

  allCars : Car[] = [];
  allCarsDisplayedColumns = ['plate', 'model', 'yearOfProduction', 'km', 'button']

  constructor(private carService: CarService, private router: Router){
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.carService.getAll().subscribe({
      next: (value) => {
        console.log("succ\n" + JSON.stringify(value));
        this.allCars = value;
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  goToAbout(id: number) {
    this.router.navigate(['/repairments', id]);
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
