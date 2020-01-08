import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { QuizTemplate } from 'src/app/models/quiz.model';
import { QuestsTemplate } from 'src/app/models/questions.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  quizzes: QuizTemplate[] = [];
  questions: QuestsTemplate[] = [];

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
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
  }

}
