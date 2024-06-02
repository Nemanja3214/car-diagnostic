import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  constructor(private http: HttpClient) { }
  getByClient(id: any) : Observable<Car[]> {
    return this.http.get<Car[]>(environment.serverOrigin + '/car/client/' + id);
  }
}

export interface Car{
  id: number,
  plate: string;
}
