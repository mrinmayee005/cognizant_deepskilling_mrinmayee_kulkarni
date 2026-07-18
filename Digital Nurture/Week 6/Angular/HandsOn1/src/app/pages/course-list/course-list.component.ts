import { Component } from '@angular/core';

@Component({
  selector: 'app-course-list',
  standalone: true,
  template: `
    <div class="course-list">
      <h2>Course Listing</h2>
      <p>Course list will be displayed here.</p>
    </div>
  `,
  styles: [`.course-list { padding: 2rem; }`]
})
export class CourseListComponent {}
