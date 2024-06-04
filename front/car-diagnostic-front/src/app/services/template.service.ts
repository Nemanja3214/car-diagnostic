import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "../environment/environment";


@Injectable({
    providedIn: 'root'
  })
  export class TemplateService {
    constructor(private http: HttpClient) { }
    sendServiceParams(params: any) : Observable<string> {
      return this.http.post<string>(environment.serverOrigin + '/template/create/service', params, {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
        })
      });
    }

    sendDiscountParams(params: any) : Observable<string> {
        return this.http.post<string>(environment.serverOrigin + '/template/create/discount', params, {
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
          })
        });
      }

  }