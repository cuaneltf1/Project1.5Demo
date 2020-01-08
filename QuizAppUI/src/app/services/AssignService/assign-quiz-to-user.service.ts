import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { QtoU } from 'src/app/models/quiztouser.model';

@Injectable({
  providedIn: 'root'
})
export class AssignQuizToUserService {

  private assignQuizErrorStream = new Subject<string>();
  $assignQuizError = this.assignQuizErrorStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) { }

  newQtoU(qtous) {
    this.httpClient.post<QtoU>(`http://localhost:8080/QuizApp/assign`, qtous, {
      withCredentials: true
    }).subscribe(
      data => {
        console.log('Quiz Assigned to User successfully');
        this.router.navigateByUrl('/home');
      },
      err => {
        console.log(err);
        this.assignQuizErrorStream.next('Failed to Assign Quiz');
      }
    );
  }
}
