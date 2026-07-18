import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class NotificationService {
  private notifications: string[] = [];
  private notificationsSubject = new BehaviorSubject<string[]>([]);

  notifications$ = this.notificationsSubject.asObservable();

  add(message: string): void {
    this.notifications.push(message);
    this.notificationsSubject.next([...this.notifications]);
  }

  clear(): void {
    this.notifications = [];
    this.notificationsSubject.next([]);
  }
}
