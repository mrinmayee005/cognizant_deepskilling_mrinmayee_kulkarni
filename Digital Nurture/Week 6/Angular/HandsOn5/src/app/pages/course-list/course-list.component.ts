import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import { Course } from '../../models/course.model';

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
export class CourseListComponent {
  selectedCourseId: number | null = null;

  courses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Algorithms', code: 'CS102', credits: 4, gradeStatus: 'pending' },
    { id: 3, name: 'Operating Systems', code: 'CS201', credits: 3, gradeStatus: 'failed' },
    { id: 4, name: 'Database Systems', code: 'CS301', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Web Development', code: 'CS401', credits: 2, gradeStatus: 'pending' }
  ];

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}
