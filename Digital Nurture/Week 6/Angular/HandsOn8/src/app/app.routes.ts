import { Routes } from '@angular/router';
import { authGuard } from './guards/auth.guard';
import { unsavedChangesGuard } from './guards/unsaved-changes.guard';

export const routes: Routes = [
  { path: '', loadComponent: () => import('./pages/home/home.component').then(m => m.HomeComponent) },
  {
    path: 'courses',
    loadComponent: () => import('./pages/courses-layout/courses-layout.component').then(m => m.CoursesLayoutComponent),
    children: [
      { path: '', loadComponent: () => import('./pages/course-list/course-list.component').then(m => m.CourseListComponent) },
      { path: ':id', loadComponent: () => import('./pages/course-detail/course-detail.component').then(m => m.CourseDetailComponent) }
    ]
  },
  { path: 'profile', canActivate: [authGuard], loadComponent: () => import('./pages/student-profile/student-profile.component').then(m => m.StudentProfileComponent) },
  { path: 'enroll', canActivate: [authGuard], canDeactivate: [unsavedChangesGuard], loadComponent: () => import('./pages/enrollment-form/enrollment-form.component').then(m => m.EnrollmentFormComponent) },
  { path: 'enroll-reactive', canDeactivate: [unsavedChangesGuard], loadComponent: () => import('./pages/reactive-enrollment-form/reactive-enrollment-form.component').then(m => m.ReactiveEnrollmentFormComponent) },
  { path: '**', loadComponent: () => import('./pages/not-found/not-found.component').then(m => m.NotFoundComponent) }
];
