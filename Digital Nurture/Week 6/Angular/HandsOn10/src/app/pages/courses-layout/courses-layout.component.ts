import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-courses-layout',
  standalone: true,
  imports: [RouterOutlet],
  template: `<div class="courses-layout"><router-outlet></router-outlet></div>`,
  styles: ['.courses-layout { min-height: 400px; }']
})
export class CoursesLayoutComponent {}
