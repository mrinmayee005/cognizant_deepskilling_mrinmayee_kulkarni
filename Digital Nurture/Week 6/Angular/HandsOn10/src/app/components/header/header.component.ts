import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  template: `
    <nav class="header-nav">
      <div class="nav-brand">Student Course Portal</div>
      <ul class="nav-links">
        <li><a routerLink="/" routerLinkActive="active" [routerLinkActiveOptions]="{exact: true}">Home</a></li>
        <li><a routerLink="/courses" routerLinkActive="active">Courses</a></li>
        <li><a routerLink="/profile" routerLinkActive="active">Profile</a></li>
      </ul>
    </nav>
  `,
  styles: [`
    .header-nav { display: flex; justify-content: space-between; align-items: center; padding: 1rem 2rem; background: #1976d2; color: white; }
    .nav-brand { font-size: 1.4rem; font-weight: bold; }
    .nav-links { list-style: none; display: flex; gap: 1.5rem; margin: 0; padding: 0; }
    .nav-links a { color: white; text-decoration: none; padding: 0.5rem 1rem; border-radius: 4px; transition: background 0.2s; }
    .nav-links a:hover, .nav-links a.active { background: rgba(255,255,255,0.2); }
  `]
})
export class HeaderComponent {}
