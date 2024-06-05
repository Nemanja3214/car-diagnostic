import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environment/environment';
import { ValidatorFn, AbstractControl } from '@angular/forms';
import { Client } from './client.service';

@Injectable({
  providedIn: 'root'
})
export class CarService {
 
  getCarModels() : Observable<CarModel[]> {
    return this.http.get<CarModel[]>(environment.serverOrigin + '/carModel');
  }

  createElectricCar(dto: CreateElectricCar): Observable<void> {
    return this.http.post<void>(environment.serverOrigin + '/car/electric', dto, {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  });
  }

  createGasCar(dto: CreateGasCar): Observable<void> {
    return this.http.post<void>(environment.serverOrigin + '/car/gas', dto, {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  });
  }

  constructor(private http: HttpClient) { }
  getByClient(id: any) : Observable<Car[]> {
    return this.http.get<Car[]>(environment.serverOrigin + '/car/client/' + id);
  }


  getAll() : Observable<any> {
    return this.http.get<any>(environment.serverOrigin + '/car/all');

  getElectricByClient(id: any)  : Observable<Car[]> {
    return this.http.get<Car[]>(environment.serverOrigin + '/car/electric/client/' + id);

  }
}

export interface Car{
  id: number,
  plate: string;
}

export interface CarModel{
  id: number,
  name: string;
}

export interface CreateCar {
  plate: string;
  yearOfProduction: number;
  km: number;
  ownerId: number;
  carModelId: number; 
}

export interface CreateElectricCar extends CreateCar{
  nominalMaxCharge: number,
  nominalMaxVoltage: number
}

export interface CreateGasCar extends CreateCar{

}

export function plateValidator(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    // format example AB123CD
    const plateRegExp: RegExp = /^[A-Z]{2}\d{3}[A-Z]{2}$/; 

    if (control.value && !plateRegExp.test(control.value)) {
      return { 'invalidPlate': true };
    }

    return null;
  };
}

