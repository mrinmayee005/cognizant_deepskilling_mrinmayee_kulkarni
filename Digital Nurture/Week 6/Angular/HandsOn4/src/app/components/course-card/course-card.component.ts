import { Component, EventEmitter, Input, OnChanges, OnDestroy, Output, SimpleChanges } from '@angular/core';
import { NgClass, NgIf, NgSwitch, NgSwitchCase, NgSwitchDefault } from '@angular/common';
import { HighlightDirective } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [NgClass, NgIf, NgSwitch, NgSwitchCase, NgSwitchDefault, HighlightDirective, CreditLabelPipe],
  template: `
    <div class="course-card" [ngClass]="cardClasses" [style.border-left-color]="borderColor" appHighlight="lightblue">
      <h3>{{ course.name }}</h3>
      <p>Code: {{ course.code }}</p>
      <p>Credits: {{ course.credits | creditLabel }}</p>
      <p>
        Status:
        <span [ngSwitch]="course.gradeStatus">
          <span *ngSwitchCase="'passed'" class="badge badge--passed">Passed</span>
          <span *ngSwitchCase="'failed'" class="badge badge--failed">Failed</span>
          <span *ngSwitchDefault class="badge badge--pending">Pending</span>
        </span>
      </p>
      <div class="card-actions">
        <button (click)="enrollRequested.emit(course.id)">Enroll</button>
        <button (click)="toggleDetails()">Show Details</button>
      </div>
      <div *ngIf="isExpanded" class="card-details">
        <p>Course ID: {{ course.id }}</p>
        <p>This course covers advanced topics in {{ course.name }}.</p>
      </div>
    </div>
  `,
  styles: [`
    .course-card { border: 1px solid #ddd; border-left: 4px solid grey; border-radius: 8px; padding: 1rem; width: 280px; transition: all 0.3s ease; background: white; }
    .course-card:hover { box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
    .card--enrolled { background: #e3f2fd; }
    .card--full { opacity: 0.85; }
    .expanded { min-height: 200px; }
    .badge { padding: 2px 8px; border-radius: 12px; font-size: 0.85rem; color: white; }
    .badge--passed { background: green; }
    .badge--failed { background: red; }
    .badge--pending { background: grey; }
    .card-actions { display: flex; gap: 0.5rem; margin-top: 0.5rem; }
    .card-actions button { padding: 0.4rem 0.8rem; border: 1px solid #1976d2; background: white; color: #1976d2; border-radius: 4px; cursor: pointer; }
    .card-actions button:hover { background: #1976d2; color: white; }
    .card-details { margin-top: 0.5rem; padding-top: 0.5rem; border-top: 1px solid #eee; }
  `]
})
export class CourseCardComponent implements OnChanges, OnDestroy {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

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

  get cardClasses(): Record<string, boolean> {
    return {
      'expanded': this.isExpanded
    };
  }

  get borderColor(): string {
    switch (this.course.gradeStatus) {
      case 'passed': return 'green';
      case 'failed': return 'red';
      case 'pending': return 'grey';
      default: return 'grey';
    }
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }
}
