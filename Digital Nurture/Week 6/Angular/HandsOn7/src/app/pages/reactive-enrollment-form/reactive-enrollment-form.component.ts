import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators, FormArray, FormControl, AbstractControl, ValidationErrors } from '@angular/forms';

export function noCourseCode(control: AbstractControl): ValidationErrors | null {
  if (control.value && typeof control.value === 'string' && control.value.startsWith('XX')) {
    return { noCourseCode: true };
  }
  return null;
}

export function simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
  return new Promise(resolve => {
    setTimeout(() => {
      if (control.value && control.value.includes('test@')) {
        resolve({ emailTaken: true });
      } else {
        resolve(null);
      }
    }, 800);
  });
}

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  template: `
    <div class="reactive-form">
      <h2>Reactive Enrollment Form</h2>

      <div *ngIf="submitted" class="success-message">
        Enrollment request submitted successfully!
      </div>

      <form [formGroup]="enrollForm" (ngSubmit)="onSubmit()" *ngIf="!submitted">
        <div class="form-group">
          <label>Student Name</label>
          <input type="text" formControlName="studentName">
          <span class="error" *ngIf="enrollForm.get('studentName')?.touched && enrollForm.get('studentName')?.errors?.['required']">Name is required</span>
          <span class="error" *ngIf="enrollForm.get('studentName')?.touched && enrollForm.get('studentName')?.errors?.['minlength']">Name must be at least 3 characters</span>
        </div>

        <div class="form-group">
          <label>Student Email</label>
          <input type="email" formControlName="studentEmail">
          <span class="error" *ngIf="enrollForm.get('studentEmail')?.touched && enrollForm.get('studentEmail')?.errors?.['required']">Email is required</span>
          <span class="error" *ngIf="enrollForm.get('studentEmail')?.touched && enrollForm.get('studentEmail')?.errors?.['email']">Please enter a valid email</span>
          <span class="error" *ngIf="enrollForm.get('studentEmail')?.errors?.['emailTaken']">Email is already taken</span>
        </div>

        <div class="form-group">
          <label>Course ID</label>
          <input type="text" formControlName="courseId">
          <span class="error" *ngIf="enrollForm.get('courseId')?.touched && enrollForm.get('courseId')?.errors?.['required']">Course ID is required</span>
          <span class="error" *ngIf="enrollForm.get('courseId')?.errors?.['noCourseCode']">Course code starting with XX is not allowed.</span>
        </div>

        <div class="form-group">
          <label>Preferred Semester</label>
          <select formControlName="preferredSemester">
            <option value="Odd">Odd</option>
            <option value="Even">Even</option>
          </select>
        </div>

        <div class="form-group">
          <label>
            <input type="checkbox" formControlName="agreeToTerms">
            I agree to the terms and conditions
          </label>
          <span class="error" *ngIf="enrollForm.get('agreeToTerms')?.touched && enrollForm.get('agreeToTerms')?.errors?.['required']">You must agree to the terms</span>
        </div>

        <div class="form-group">
          <label>Additional Courses</label>
          <div *ngFor="let ctrl of additionalCourseControls; let i = index" class="additional-course">
            <input [formControl]="ctrl" placeholder="Course name">
            <button type="button" (click)="removeCourse(i)">Remove</button>
          </div>
          <button type="button" (click)="addCourse()">Add Another Course</button>
        </div>

        <div class="form-actions">
          <button type="submit" [disabled]="enrollForm.invalid">Submit</button>
        </div>
      </form>

      <button *ngIf="submitted" (click)="submitted = false; enrollForm.reset({preferredSemester: 'Odd', agreeToTerms: false})">Submit Another</button>
    </div>
  `,
  styles: [`
    .reactive-form { padding: 2rem; max-width: 500px; }
    .form-group { margin-bottom: 1rem; }
    .form-group label { display: block; margin-bottom: 0.3rem; font-weight: bold; }
    .form-group input, .form-group select { width: 100%; padding: 0.5rem; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
    .error { color: red; font-size: 0.85rem; }
    .success-message { background: #e8f5e9; color: #2e7d32; padding: 1rem; border-radius: 4px; margin-bottom: 1rem; }
    .form-actions { display: flex; gap: 0.5rem; margin-top: 1rem; }
    .form-actions button, button[type="button"] { padding: 0.5rem 1.5rem; border: 1px solid #1976d2; background: #1976d2; color: white; border-radius: 4px; cursor: pointer; }
    .form-actions button:disabled { background: #ccc; border-color: #ccc; cursor: not-allowed; }
    .additional-course { display: flex; gap: 0.5rem; margin-bottom: 0.5rem; }
    .additional-course input { flex: 1; }
    .additional-course button { background: red; border-color: red; }
  `]
})
export class ReactiveEnrollmentFormComponent implements OnInit {
  enrollForm!: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: ['', [Validators.required, Validators.email], [simulateEmailCheck]],
      courseId: ['', [Validators.required, noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  get additionalCourseControls(): FormControl[] {
    return this.additionalCourses.controls as FormControl[];
  }

  addCourse(): void {
    this.additionalCourses.push(this.fb.control('', Validators.required));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    // form.value excludes disabled controls; getRawValue() includes all controls
    console.log('Form value:', this.enrollForm.value);
    console.log('Raw value:', this.enrollForm.getRawValue());
    this.submitted = true;
  }
}
