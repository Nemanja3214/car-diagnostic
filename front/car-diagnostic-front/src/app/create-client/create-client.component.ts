import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField,  MatFormFieldModule, MatFormFieldControl } from '@angular/material/form-field';
import { ClientService, CreateClient, phoneNumberValidator } from '../services/client.service';
import { SnackbarService } from '../services/snackbar.service';
import { HttpClientModule } from '@angular/common/http';
import {MatCardModule} from '@angular/material/card';
@Component({
  selector: 'app-create-client',
  standalone: true,
  imports: [MatInputModule, MatButtonModule, FormsModule, MatFormFieldModule, ReactiveFormsModule, HttpClientModule,
    MatCardModule],
  templateUrl: './create-client.component.html',
  providers:[ClientService],
  styleUrl: './create-client.component.css'
})
export class CreateClientComponent {

  userForm: FormGroup = this.fb.group({
    name: ['', Validators.required],
    lastName: ['', Validators.required],
    phone: ['', [Validators.required, phoneNumberValidator()]]
  });

  constructor(private fb: FormBuilder, private clientService: ClientService, private snackbarService: SnackbarService) { }

  onSubmit() {
    if (!this.userForm.valid) {
      return;
    }
    const dto: CreateClient = {
      name: this.userForm.value.name!,
      lastName: this.userForm.value.lastName!,
      phone: this.userForm.value.phone!,
    };
    console.log(dto);
    this.clientService.createClient(dto).subscribe(
      (response) => {
        console.log(response);
        this.snackbarService.showSnackbar("Success");
      },
      (error) => {
        // This block will only execute if catchError is used
        console.error('Error handler:', error);
      }
    );
  }
}
