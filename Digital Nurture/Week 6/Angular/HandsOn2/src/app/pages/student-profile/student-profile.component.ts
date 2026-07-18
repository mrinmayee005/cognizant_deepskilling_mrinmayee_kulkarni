import { Component } from '@angular/core';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  template: `
    <div class="profile">
      <h2>Student Profile</h2>
      <p>Student profile will be displayed here.</p>
    </div>
  `,
  styles: [`.profile { padding: 2rem; }`]
})
export class StudentProfileComponent {}
