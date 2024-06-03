import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { CommonModule } from '@angular/common';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-modify-template',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, ReactiveFormsModule, HttpClientModule, MatInputModule, CommonModule,],
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

}
