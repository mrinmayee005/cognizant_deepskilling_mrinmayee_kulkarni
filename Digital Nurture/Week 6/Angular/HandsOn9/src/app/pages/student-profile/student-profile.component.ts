import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { selectEnrolledCourses } from '../../store/enrollment/enrollment.selectors';
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
      <div *ngIf="enrolledCourses$ | async as courses">
        <p *ngIf="courses.length === 0">No courses enrolled yet.</p>
        <ul>
          <li *ngFor="let course of courses">
            {{ course.name }} ({{ course.code }}) — {{ course.credits }} credits
          </li>
        </ul>
      </div>
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
export class StudentProfileComponent implements OnInit {
  enrolledCourses$!: Observable<Course[]>;

  constructor(private store: Store) {}

  ngOnInit(): void {
    this.enrolledCourses$ = this.store.select(selectEnrolledCourses);
  }
}
