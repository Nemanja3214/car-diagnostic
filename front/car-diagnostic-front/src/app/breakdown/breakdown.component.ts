import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField,  MatFormFieldModule, MatFormFieldControl } from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { BreakdownService } from './../services/breakdown.service';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';

@Component({
  selector: 'app-breakdown',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, ReactiveFormsModule, MatInputModule, CommonModule, MatCardModule, MatSelectModule, BrowserModule,
    HttpClientModule, JwtModule],
  templateUrl: './breakdown.component.html',
  styleUrl: './breakdown.component.css'
})
export class BreakdownComponent {
  constructor(private breakdownService: BreakdownService){
  }

  form = new FormGroup({
    name: new FormControl('', [Validators.required]),
    symptoms: new FormControl('', [Validators.required]),
  });

  availableItems: string[] = ['Item 1', 'Item 2', 'Item 3', 'Item 4'];
  selectedItems: string[] = [];

  addItem() {
    const availableList = document.querySelector('#availableList') as HTMLSelectElement;
    const selectedList = document.querySelector('#selectedList') as HTMLSelectElement;

    if (availableList && selectedList) {
      const selectedOptions = Array.from(availableList.selectedOptions);
      selectedOptions.forEach(option => {
        const value = option.value;
        this.selectedItems.push(value);
        const index = this.availableItems.indexOf(value);
        if (index !== -1) {
          this.availableItems.splice(index, 1);
        }
      });

      // Clear selected options
      availableList.selectedIndex = -1;
    }
  }

  // onSubmit() {
  //   // this.submited = true;

  //   const credentials = {
  //     email: this.loginForm.value.email,
  //     password: this.loginForm.value.password
  //   };

  //   this.breakdownService.create(credentials).subscribe({
  //     next: (result) => {
  //       this.processLogin(result);
  //     },
  //       error: (error) => {
  //       console.log(error);
  //       console.log("tu")
  //       console.log(error.error)
  //     //   this.snackBar.open("Bad credentials. Please try again!", "", {
  //     //     duration: 2700, panelClass: ['snack-bar-server-error']
  //     //  });
  //     },
  //   });
  // }
}
