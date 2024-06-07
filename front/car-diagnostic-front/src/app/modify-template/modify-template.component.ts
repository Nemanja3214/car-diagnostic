import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { CommonModule } from '@angular/common';
import { MatButton } from '@angular/material/button';
import { TemplateService } from '../services/template.service';

@Component({
  selector: 'app-modify-template',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, ReactiveFormsModule, HttpClientModule, MatInputModule, CommonModule,],
  providers:[TemplateService],
  templateUrl: './modify-template.component.html',
  styleUrl: './modify-template.component.css'
})
export class ModifyTemplateComponent {

  discountForm = new FormGroup({
    lower: new FormControl('', [Validators.required]),
    upper: new FormControl('', [Validators.required]),
  });

  serviceForm = new FormGroup({
    smallService: new FormControl('', [Validators.required]),
    bigService: new FormControl('', [Validators.required]),
    brakes: new FormControl('', [Validators.required]),
    tires: new FormControl('', [Validators.required]),
  });

  constructor(private templateService: TemplateService) {}


  sendServiceParams() {
    // this.submited = true;

    const params = {
      smallService: this.serviceForm.value.smallService,
      bigService: this.serviceForm.value.bigService,
      brakes: this.serviceForm.value.brakes,
      tires: this.serviceForm.value.tires,
    };

    if (this.serviceForm.valid) {
      this.templateService.sendServiceParams(params).subscribe({
        next: (result) => {
          console.log(result);
        },
         error: (error) => {
          console.log(error);
          console.log("tu")
          console.log(error.error)
        //   this.snackBar.open("Bad credentials. Please try again!", "", {
        //     duration: 2700, panelClass: ['snack-bar-server-error']
        //  });
        },
      });
    }
  }

  sendDiscountParams() {

    const params = {
      lower: this.discountForm.value.lower,
      upper: this.discountForm.value.upper,
    };

    // if (this.discountForm.valid) {
      console.log('usao')
      this.templateService.sendDiscountParams(params).subscribe({
        next: (result) => {
          console.log(result);
        },
         error: (error) => {
          console.log(error);
          console.log("tu")
          console.log(error.error)
        //   this.snackBar.open("Bad credentials. Please try again!", "", {
        //     duration: 2700, panelClass: ['snack-bar-server-error']
        //  });
        },
      });
    // }
  }

}
