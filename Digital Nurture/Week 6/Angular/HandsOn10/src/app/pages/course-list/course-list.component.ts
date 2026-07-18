import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import { Course } from '../../models/course.model';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses, selectCoursesLoading } from '../../store/course/course.selectors';
import { enrollInCourse } from '../../store/enrollment/enrollment.actions';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  template: `
    <div class="course-list">
      <h2>Course Listing</h2>

      <div *ngIf="loading$ | async" class="loading"><p>Loading courses...</p></div>

      <div class="course-grid">
        <ng-container *ngIf="courses$ | async as courses">
          <app-course-card
            *ngFor="let c of courses; trackBy: trackByCourseId"
            [course]="c"
            (enrollRequested)="onEnroll($event)">
          </app-course-card>
        </ng-container>
      </div>
      <p *ngIf="selectedCourseId">Selected course ID: {{ selectedCourseId }}</p>
    </div>
  `,
  styles: [`
    .course-list { padding: 2rem; }
    .course-grid { display: flex; flex-wrap: wrap; gap: 1rem; }
    .loading { font-size: 1.2rem; color: #666; }
  `]
})
export class CourseListComponent implements OnInit {
  courses$!: Observable<Course[]>;
  loading$!: Observable<boolean>;
  enrolledIds$!: Observable<number[]>;
  selectedCourseId: number | null = null;

  constructor(private store: Store) {}

  ngOnInit(): void {
    this.store.dispatch(loadCourses());
    this.courses$ = this.store.select(selectAllCourses);
    this.loading$ = this.store.select(selectCoursesLoading);
    this.enrolledIds$ = this.store.select(selectEnrolledIds);
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
    this.store.dispatch(enrollInCourse({ courseId }));
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}
