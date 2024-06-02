import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class BreakdownService {

  constructor(private http: HttpClient) { }

  getSymptoms(): Observable<string[]> {
    return this.http.get<string[]>(environment.serverOrigin + '/breakdown/symptoms');
}

createBreakdown(createBreakdown: CreateBreakdown): Observable<string> {
  return this.http.post<string>(environment.serverOrigin + '/breakdown/create', createBreakdown, {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  });
}
}

export interface CreateBreakdown{
  name: string,
  // carId: number,
  symptoms: string[]
}
