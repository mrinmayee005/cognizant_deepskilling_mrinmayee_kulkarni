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
  `]
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [];
  selectedCourseId: number | null = null;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.courses = this.courseService.getCourses();
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}
