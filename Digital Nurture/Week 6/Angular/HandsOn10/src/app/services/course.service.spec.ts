import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Algorithms', code: 'CS102', credits: 3, gradeStatus: 'pending' }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get courses via GET', () => {
    service.getCourses().subscribe(courses => {
      expect(courses.length).toBe(2);
      expect(courses[0].name).toBe('Data Structures');
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);
  });

  it('should handle error on getCourses', () => {
    service.getCourses().subscribe(courses => {
      expect(courses.length).toBe(0);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    req.flush('Error', { status: 500, statusText: 'Server Error' });
  });

  it('should get course by id', () => {
    service.getCourseById(1).subscribe(course => {
      expect(course?.name).toBe('Data Structures');
    });

    const req = httpMock.expectOne('http://localhost:3000/courses/1');
    req.flush(mockCourses[0]);
  });

  it('should create a course via POST', () => {
    const newCourse = { name: 'AI', code: 'CS501', credits: 3, gradeStatus: 'pending' as const };
    service.createCourse(newCourse).subscribe(course => {
      expect(course.name).toBe('AI');
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('POST');
    req.flush({ id: 6, ...newCourse });
  });

  it('should delete a course via DELETE', () => {
    service.deleteCourse(1).subscribe();

    const req = httpMock.expectOne('http://localhost:3000/courses/1');
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
