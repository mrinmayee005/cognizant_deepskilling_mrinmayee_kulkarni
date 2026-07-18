import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule, NgIf],
  template: `
    <div class="home">
      <h1>{{ portalName }}</h1>
      <p>Welcome to the Student Course Portal. Manage your courses, enroll in new ones, and track your academic progress.</p>

      <div class="stats-row">
        <div class="stat-card"><h3>Courses Available</h3><p>{{ coursesAvailable }}</p></div>
        <div class="stat-card"><h3>Enrolled</h3><p>{{ enrolled }}</p></div>
        <div class="stat-card"><h3>GPA</h3><p>{{ gpa }}</p></div>
      </div>

      <div class="actions">
        <button [disabled]="!isPortalActive" (click)="onEnrollClick()">Enroll Now</button>
        <p *ngIf="message">{{ message }}</p>
      </div>

      <div class="search">
        <input [(ngModel)]="searchTerm" placeholder="Search courses...">
        <p>Searching for: {{ searchTerm }}</p>
        <!-- [property] is one-way binding: component -> DOM. [(ngModel)] is two-way: DOM <-> component -->
      </div>
    </div>
  `,
  styles: [`
    .home { padding: 2rem; }
    .stats-row { display: flex; gap: 1.5rem; margin: 1.5rem 0; }
    .stat-card { background: #f5f5f5; padding: 1.5rem; border-radius: 8px; text-align: center; min-width: 150px; }
    .stat-card h3 { margin: 0 0 0.5rem; color: #555; }
    .stat-card p { font-size: 2rem; margin: 0; color: #1976d2; font-weight: bold; }
    .actions { margin: 1.5rem 0; }
    .actions button { padding: 0.7rem 1.5rem; background: #1976d2; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 1rem; }
    .actions button:disabled { background: #ccc; cursor: not-allowed; }
    .search { margin: 1.5rem 0; }
    .search input { padding: 0.5rem 1rem; border: 1px solid #ddd; border-radius: 4px; width: 300px; }
  `]
})
export class HomeComponent implements OnInit, OnDestroy {
  portalName = 'Student Course Portal';
  isPortalActive = true;
  searchTerm = '';
  message = '';
  coursesAvailable = 12;
  enrolled = 3;
  gpa = 3.8;

  ngOnInit(): void {
    console.log('HomeComponent initialised — courses loaded');
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}
