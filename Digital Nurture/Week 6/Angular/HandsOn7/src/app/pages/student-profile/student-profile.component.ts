import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EnrollmentService } from '../../services/enrollment.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="profile">
      <h2>Student Profile</h2>
      <div class="profile-info">
        <p><strong>Name:</strong> John Doe</p>
        <p><strong>Email:</strong> john.doe@college.edu</p>
        <p><strong>Student ID:</strong> STU-2024-001</p>
      </div>

      <h3>Enrolled Courses</h3>
      <p *ngIf="enrolledCourses.length === 0">No courses enrolled yet.</p>
      <ul>
        <li *ngFor="let course of enrolledCourses">
          {{ course.name }} ({{ course.code }}) — {{ course.credits }} credits
        </li>
      </ul>
    </div>
  `,
  styles: [`
    .profile { padding: 2rem; }
    .profile-info { background: #f5f5f5; padding: 1.5rem; border-radius: 8px; margin-bottom: 1.5rem; }
    .profile-info p { margin: 0.5rem 0; }
    ul { list-style: none; padding: 0; }
    ul li { padding: 0.75rem; border: 1px solid #ddd; border-radius: 4px; margin-bottom: 0.5rem; background: white; }
  `]
})
export class StudentProfileComponent {
  enrolledCourses: Course[] = [];

  constructor(private enrollmentService: EnrollmentService) {
    this.enrolledCourses = this.enrollmentService.getEnrolledCourses();
  }
}
