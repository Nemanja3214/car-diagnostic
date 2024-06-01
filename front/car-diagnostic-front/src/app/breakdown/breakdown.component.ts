import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField,  MatFormFieldModule, MatFormFieldControl } from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { BreakdownService } from './../services/breakdown.service';
import { HttpClientModule } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';

@Component({
  selector: 'app-breakdown',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, ReactiveFormsModule, MatInputModule, CommonModule, MatCardModule, MatSelectModule,
    HttpClientModule, JwtModule],
  templateUrl: './breakdown.component.html',
  providers:[BreakdownService],
  styleUrl: './breakdown.component.css'
})
export class BreakdownComponent implements OnInit{
  private selectedIndexes: Array<number> = [];
  constructor(private breakdownService: BreakdownService){
  }
  ngOnInit(): void {
    this.breakdownService.getSymptoms() .subscribe(
      (response) => {
        // Handle the successful response
        this.availableItems = response
      },
      (error) => {
        // This block will only execute if catchError is used
        console.error('Error handler:', error);
      }
    );;
  }

  form = new FormGroup({
    name: new FormControl('', [Validators.required]),
    symptoms: new FormControl('', [Validators.required]),
  });

  availableItems: string[] = []; // Sample available items
  selectedItems: string[] = []; // Initially, selected items are empty

  addItem() {
    // Loop through available items and check if they are selected
    this.availableItems.forEach(item => {
      const index = this.selectedItems.indexOf(item);
      // If item is selected and not already in the selectedItems array, add it
      if (index !== -1 && !this.selectedItems.includes(item)) {
        this.selectedItems.push(item);
      }
    });
    console.log(this.selectedItems);
  }


  onSelectionChange(event: any) {
    this.selectedItems = event.value;
    console.log(this.selectedItems);
    // this.selectedItems.push(item);
    // console.log('Selected Items:', this.selectedItems);
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
