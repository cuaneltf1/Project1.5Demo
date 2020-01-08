import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject, ReplaySubject } from 'rxjs';
import { QuizTemplate } from 'src/app/models/quiz.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CreateQuizService {

  private createQuizErrorStream = new Subject<string>();
  $createQuizError = this.createQuizErrorStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) {
   }

   newQuiz(quizzes) {
     this.httpClient.post<QuizTemplate>(`http://localhost:8080/QuizApp/quiz/create`, quizzes, {
       withCredentials: true
     }).subscribe(
       data => {
         console.log('Quiz created');
         this.router.navigateByUrl('/home');
       },
       err => {
         console.log(err);
         this.createQuizErrorStream.next('Failed to create quiz');
       }
     );
   }
}
