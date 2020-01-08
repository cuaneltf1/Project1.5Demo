import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { QuizTemplate } from 'src/app/models/quiz.model';
import { QuestsTemplate } from 'src/app/models/questions.model';
import { AssignedQutoQ } from 'src/app/models/aqutoq.model';
import { Subscription } from 'rxjs';
import { AssignQuestToQuizService } from 'src/app/services/AssignService/assign-quest-to-quiz.service';

@Component({
  selector: 'app-quest-to-quiz',
  templateUrl: './quest-to-quiz.component.html',
  styleUrls: ['./quest-to-quiz.component.css']
})
export class QuestToQuizComponent implements OnInit, OnDestroy {

  quizzes: QuizTemplate[] = [];
  questions: QuestsTemplate[] = [];
  aqutoqs: AssignedQutoQ[] = [];

  qutoqs = {
    quiz_id: undefined,
    question_id: undefined
  };

  errorMessage = '';
  errorMessageSubscription: Subscription;

  constructor(private assignQuestToQuizService: AssignQuestToQuizService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.errorMessageSubscription = this.assignQuestToQuizService.$assignQuestError.subscribe(errorMessage => {
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

    this.httpClient.get<QuestsTemplate[]>(`http://localhost:8080/QuizApp/question`, {
      withCredentials: true
    })
    .subscribe(data => {
      console.log(data);
      this.questions = data;
    },
    err => {
      console.log(err);
    });

    this.httpClient.get<AssignedQutoQ[]>(`http://localhost:8080/QuizApp/testquest`, {
          withCredentials: true
        })
    .subscribe(data => {
      console.log(data);
      this.aqutoqs = data;
    },
    err => {
      console.log(err);
    });
  }

  newQutoQ() {
    this.assignQuestToQuizService.newQutoQ(this.qutoqs);
  }

  ngOnDestroy() {
    this.errorMessageSubscription.unsubscribe();
  }
}
