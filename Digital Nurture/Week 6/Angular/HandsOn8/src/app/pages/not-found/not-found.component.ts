import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [RouterLink],
  template: `
    <div class="not-found">
      <h2>404 - Page Not Found</h2>
      <p>The page you are looking for does not exist.</p>
      <a routerLink="/">Go Home</a>
    </div>
  `,
  styles: [`
    .not-found { padding: 2rem; text-align: center; }
    .not-found h2 { color: #d32f2f; }
    a { color: #1976d2; text-decoration: none; font-size: 1.1rem; }
  `]
})
export class NotFoundComponent {}
