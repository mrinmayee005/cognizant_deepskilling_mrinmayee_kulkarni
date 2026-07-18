import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-enrollment-form',
  standalone: true,
  imports: [FormsModule, NgIf],
  template: `
    <div class="enrollment-form">
      <h2>Enrollment Request Form</h2>

      <div *ngIf="submitted" class="success-message">
        Enrollment request submitted successfully!
      </div>

      <form #enrollForm="ngForm" (ngSubmit)="onSubmit(enrollForm)" *ngIf="!submitted">
        <div class="form-group">
          <label>Student Name</label>
          <input type="text" name="studentName" [(ngModel)]="enrollForm.value.studentName" #nameCtrl="ngModel" required minlength="3">
          <span class="error" *ngIf="nameCtrl.touched && nameCtrl.errors?.['required']">Name is required</span>
          <span class="error" *ngIf="nameCtrl.touched && nameCtrl.errors?.['minlength']">Name must be at least 3 characters</span>
        </div>

        <div class="form-group">
          <label>Student Email</label>
          <input type="email" name="studentEmail" [(ngModel)]="enrollForm.value.studentEmail" #emailCtrl="ngModel" required email>
          <span class="error" *ngIf="emailCtrl.touched && emailCtrl.errors?.['required']">Email is required</span>
          <span class="error" *ngIf="emailCtrl.touched && emailCtrl.errors?.['email']">Please enter a valid email</span>
        </div>

        <div class="form-group">
          <label>Course ID</label>
          <input type="number" name="courseId" [(ngModel)]="enrollForm.value.courseId" #courseIdCtrl="ngModel" required>
          <span class="error" *ngIf="courseIdCtrl.touched && courseIdCtrl.errors?.['required']">Course ID is required</span>
        </div>

        <div class="form-group">
          <label>Preferred Semester</label>
          <select name="preferredSemester" [(ngModel)]="enrollForm.value.preferredSemester" required>
            <option value="Odd">Odd</option>
            <option value="Even">Even</option>
          </select>
        </div>

        <div class="form-group">
          <label>
            <input type="checkbox" name="agreeToTerms" [(ngModel)]="enrollForm.value.agreeToTerms" #termsCtrl="ngModel" required>
            I agree to the terms and conditions
          </label>
          <span class="error" *ngIf="termsCtrl.touched && termsCtrl.errors?.['required']">You must agree to the terms</span>
        </div>

        <div class="form-actions">
          <button type="submit" [disabled]="enrollForm.invalid">Submit</button>
          <button type="button" (click)="onReset(enrollForm)">Reset</button>
        </div>
      </form>

      <button *ngIf="submitted" (click)="submitted = false">Submit Another</button>
    </div>
  `,
  styles: [`
    .enrollment-form { padding: 2rem; max-width: 500px; }
    .form-group { margin-bottom: 1rem; }
    .form-group label { display: block; margin-bottom: 0.3rem; font-weight: bold; }
    .form-group input, .form-group select { width: 100%; padding: 0.5rem; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
    .error { color: red; font-size: 0.85rem; }
    .success-message { background: #e8f5e9; color: #2e7d32; padding: 1rem; border-radius: 4px; margin-bottom: 1rem; }
    .form-actions { display: flex; gap: 0.5rem; margin-top: 1rem; }
    .form-actions button { padding: 0.5rem 1.5rem; border: 1px solid #1976d2; background: #1976d2; color: white; border-radius: 4px; cursor: pointer; }
    .form-actions button:disabled { background: #ccc; border-color: #ccc; cursor: not-allowed; }
    .form-actions button[type="button"] { background: white; color: #1976d2; }
    .ng-invalid.ng-touched { border-color: red; }
    .ng-valid.ng-touched { border-color: green; }
  `]
})
export class EnrollmentFormComponent {
  submitted = false;

  onSubmit(form: NgForm): void {
    console.log(form.value);
    console.log('Form valid:', form.valid);
    this.submitted = true;
  }

  onReset(form: NgForm): void {
    form.resetForm();
    this.submitted = false;
  }
}
