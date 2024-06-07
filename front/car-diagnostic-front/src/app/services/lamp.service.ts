import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "../environment/environment";


@Injectable({
    providedIn: 'root'
  })
  export class LampService {
    constructor(private http: HttpClient) { }

      checkLamps(params: any, carId: string) : Observable<any> {
        return this.http.post<any>(environment.serverOrigin + '/lamp/check/' + carId, params, {
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
          })
        });
      }

  }