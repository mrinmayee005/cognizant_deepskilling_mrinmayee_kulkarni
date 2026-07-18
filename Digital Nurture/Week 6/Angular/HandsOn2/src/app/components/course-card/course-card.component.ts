import { Component, EventEmitter, Input, OnChanges, OnDestroy, Output, SimpleChanges } from '@angular/core';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-card',
  standalone: true,
  template: `
    <div class="course-card">
      <h3>{{ course.name }}</h3>
      <p>Code: {{ course.code }}</p>
      <p>Credits: {{ course.credits }}</p>
      <p>Status: {{ course.gradeStatus }}</p>
      <button (click)="enrollRequested.emit(course.id)">Enroll</button>
    </div>
  `,
  styles: [`
    .course-card { border: 1px solid #ddd; border-radius: 8px; padding: 1rem; width: 280px; background: white; }
    .course-card h3 { color: #1976d2; }
    .course-card button { margin-top: 0.5rem; padding: 0.4rem 0.8rem; border: 1px solid #1976d2; background: white; color: #1976d2; border-radius: 4px; cursor: pointer; }
    .course-card button:hover { background: #1976d2; color: white; }
  `]
})
export class CourseCardComponent implements OnChanges, OnDestroy {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      const prev = changes['course'].previousValue;
      const curr = changes['course'].currentValue;
      console.log(`Course changed - Previous: ${prev?.name}, Current: ${curr?.name}`);
    }
  }

  ngOnDestroy(): void {
    console.log('CourseCardComponent destroyed');
  }
}
