import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  template: `
    <div class="home">
      <h1>Student Course Portal</h1>
      <p>Welcome to the Student Course Portal. Manage your courses, enroll in new ones, and track your academic progress.</p>
      <div class="stats-row">
        <div class="stat-card"><h3>Courses Available</h3><p>12</p></div>
        <div class="stat-card"><h3>Enrolled</h3><p>3</p></div>
        <div class="stat-card"><h3>GPA</h3><p>3.8</p></div>
      </div>
    </div>
  `,
  styles: [`
    .home { padding: 2rem; }
    .stats-row { display: flex; gap: 1.5rem; margin: 1.5rem 0; }
    .stat-card { background: #f5f5f5; padding: 1.5rem; border-radius: 8px; text-align: center; min-width: 150px; }
    .stat-card h3 { margin: 0 0 0.5rem; color: #555; }
    .stat-card p { font-size: 2rem; margin: 0; color: #1976d2; font-weight: bold; }
  `]
})
export class HomeComponent {}
