import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environment/environment';
import { RepairmentDTO } from '../repairments/repairments.component';

@Injectable({
  providedIn: 'root'
})
export class BreakdownService {



  constructor(private http: HttpClient) { }

  getSymptoms(isElectric: boolean): Observable<string[]> {
    return this.http.get<string[]>(environment.serverOrigin + '/breakdown/symptoms', {
      params: {
        purpose: isElectric ? "ELECTRIC": "GAS",
      }});
}

createBreakdown(createBreakdown: CreateBreakdown): Observable<RepairmentDTO[]> {
  return this.http.post<RepairmentDTO[]>(environment.serverOrigin + '/breakdown/create', createBreakdown, {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  });
}

checkBattery(carId: number, caseScenarion: number) {
  return this.http.get<BatteryCheck>(environment.serverOrigin + '/breakdown/check-battery/' + carId,  {
    params: {
      caseScenario: caseScenarion,
    }});
}
sameCases(s: string[]): Observable<number> {
  return this.http.post<number>(environment.serverOrigin + '/breakdown/same-symptoms', {symptoms: s}, {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  });
}
}

export interface CreateBreakdown{
  name: string,
  carId: number,
  symptoms: string[],
  engineLamp: boolean,
  codeLamp: boolean,
  isElectric: boolean
}

export interface GraphData{
  startTime: string,
  value: number,
  batteryId: number,
  currentSOC: number,
  currentCharge: number
}

export interface BatteryCheck{
  currentReadings: GraphData[],
  repairments: RepairmentDTO[]
}
