import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription, from } from 'rxjs';
import { AssignQuizToUserService } from 'src/app/services/AssignService/assign-quiz-to-user.service';
import { AQtoU } from 'src/app/models/aqtou.model';
import { HttpClient } from '@angular/common/http';
import { QuizTemplate } from 'src/app/models/quiz.model';
import { AppUser } from 'src/app/models/user.model';

@Component({
  selector: 'app-quiz-to-user',
  templateUrl: './quiz-to-user.component.html',
  styleUrls: ['./quiz-to-user.component.css']
})
export class QuizToUserComponent implements OnInit, OnDestroy {

  aqtous: AQtoU[] = [];
  quizzes: QuizTemplate[] = [];
  users: AppUser[] = [];

  qtous = {
    user_id: undefined,
    quiz_id: undefined
  };

  errorMessage = '';
  errorMessageSubscription: Subscription;

  constructor(private assignQuizToUserService: AssignQuizToUserService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.errorMessageSubscription = this.assignQuizToUserService.$assignQuizError.subscribe(errorMessage => {
      this.errorMessage = errorMessage;
    });

    this.httpClient.get<QuizTemplate[]>(`http://localhost:8080/QuizApp/quiz`, {
      withCredentials: true
    })
    .subscribe(data => {
      console.log(data);
      this.quizzes = data;
    },
    err => {
      console.log(err);
    });

    this.httpClient.get<AQtoU[]>(`http://localhost:8080/QuizApp/userquiz`, {
      withCredentials: true
    }).subscribe(data => {
      console.log(data);
      this.aqtous = data;
    },
    err => {
      console.log(err);
    });

    this.httpClient.get<AppUser[]>(`http://localhost:8080/QuizApp/users`, {
      withCredentials: true
    }).subscribe(data => {
      console.log(data);
      this.users = data;
    },
    err => {
      console.log(err);
    });
  }

  newQtoU() {
    this.assignQuizToUserService.newQtoU(this.qtous);
  }

  ngOnDestroy() {
    this.errorMessageSubscription.unsubscribe();
  }
}
