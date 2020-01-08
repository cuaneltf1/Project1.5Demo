import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { QATemplate } from 'src/app/models/qa.model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CreateQuestionsService {

  private questCreationErrorStream = new Subject<string>();
  $questCreationError = this.questCreationErrorStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) { }

  newQA(qas) {
    this.httpClient.post<QATemplate>(`http://localhost:8080/QuizApp/question/create`, qas, {
      withCredentials: true
    }).subscribe(
      data => {
        console.log('Question and AnswerKey created');
        this.router.navigateByUrl('/home');
      },
      err => {
        console.log(err);
        this.questCreationErrorStream.next('Failed to create Question and AnswerKey');
      }
    );
  }
}
