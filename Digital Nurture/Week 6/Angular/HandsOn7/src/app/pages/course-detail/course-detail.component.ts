import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../../models/course.model';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="course-detail" *ngIf="course; else notFound">
      <h2>{{ course.name }}</h2>
      <p><strong>Code:</strong> {{ course.code }}</p>
      <p><strong>Credits:</strong> {{ course.credits }}</p>
      <p><strong>Status:</strong> {{ course.gradeStatus }}</p>
    </div>
    <ng-template #notFound>
      <div class="course-detail">
        <h2>Course Not Found</h2>
        <p>No course found with ID {{ courseId }}.</p>
      </div>
    </ng-template>
  `,
  styles: [`
    .course-detail { padding: 2rem; }
    .course-detail h2 { color: #1976d2; }
    .course-detail p { font-size: 1.1rem; margin: 0.5rem 0; }
  `]
})
export class CourseDetailComponent implements OnInit {
  course: Course | undefined;
  courseId: number = 0;

  constructor(
    private route: ActivatedRoute,
    private courseService: CourseService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    this.courseId = idParam ? +idParam : 0;
    this.course = this.courseService.getCourseById(this.courseId);
  }
}
