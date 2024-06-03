import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  constructor(private http: HttpClient) { }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(environment.serverOrigin + '/client');
  }

  createClient(createClient: CreateClient): Observable<void> {
    return this.http.post<void>(environment.serverOrigin + '/client', createClient, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    });
  }
}

export interface Client{
  id: number,
  name: string;
  lastName: string;
  phone: string;
}

export interface CreateClient{
  name: string;
  lastName: string;
  phone: string;
}

import { AbstractControl, ValidatorFn } from '@angular/forms';

export function phoneNumberValidator(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    const phoneNumber: string = control.value;
    const phoneNumberPattern = /^(\+381|0)(6([0-6]|[8-9]))(\d{6,7})$/;
    
    if (!phoneNumberPattern.test(phoneNumber)) {
      // Validation failed
      return { 'serbianPhoneNumber': { value: control.value } };
    }
    // Validation passed
    return null;
  };
}