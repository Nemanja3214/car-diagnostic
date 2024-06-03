import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable, NgModule } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from '../environment/environment';

@Injectable({
  providedIn: 'root',
})
export class RepairmentService {
    private headers = new HttpHeaders({
        'Content-Type': 'application/json'
      });

      constructor(private http: HttpClient) {
        console.log(http);
       }

    getCarInfo(id: number): Observable<any> {
    return this.http.get<any>(environment.serverOrigin + "/car/info/" + id, {
        headers: new HttpHeaders({
            'Content-Type': 'application/json',
        })
    });
    }

    getRepairmentsByCarId(id: number): Observable<any> {
      return this.http.get<any>(environment.serverOrigin + "/repairment/getAll/" + id, {
          headers: new HttpHeaders({
              'Content-Type': 'application/json',
          })
      });
      }
} 