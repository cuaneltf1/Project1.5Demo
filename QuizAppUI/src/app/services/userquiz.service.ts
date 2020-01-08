import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserquizService {

  private userQuizErrorStream = new Subject<string>();
  $userQuizErro = this.userQuizErrorStream.asObservable();

  constructor() { }
}
