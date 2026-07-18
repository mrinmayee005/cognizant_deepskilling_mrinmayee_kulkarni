import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import { Course } from '../../models/course.model';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  template: `
    <div class="course-list">
      <h2>Course Listing</h2>

      <div *ngIf="isLoading" class="loading"><p>Loading courses...</p></div>
      <div *ngIf="errorMessage" class="error"><p>{{ errorMessage }}</p></div>

      <div class="course-grid">
        <app-course-card
          *ngFor="let c of courses; trackBy: trackByCourseId"
          [course]="c"
          (enrollRequested)="onEnroll($event)">
        </app-course-card>
      </div>
      <p *ngIf="selectedCourseId">Selected course ID: {{ selectedCourseId }}</p>
    </div>
  `,
  styles: [`
    .course-list { padding: 2rem; }
    .course-grid { display: flex; flex-wrap: wrap; gap: 1rem; }
    .loading { font-size: 1.2rem; color: #666; }
    .error { color: red; }
  `]
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [];
  selectedCourseId: number | null = null;
  isLoading = true;
  errorMessage = '';

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.courseService.getCourses().subscribe({
      next: courses => {
        this.courses = courses;
        this.isLoading = false;
      },
      error: err => {
        this.errorMessage = err.message;
        this.isLoading = false;
      }
    });
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}
