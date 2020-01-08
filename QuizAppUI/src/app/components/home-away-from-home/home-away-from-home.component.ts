import { Component, OnInit } from '@angular/core';
import { UserQuizzes } from 'src/app/models/userquizzes.model'
import { Subscription } from 'rxjs';
import { UserquizService } from 'src/app/services/userquiz.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home-away-from-home',
  templateUrl: './home-away-from-home.component.html',
  styleUrls: ['./home-away-from-home.component.css']
})
export class HomeAwayFromHomeComponent implements OnInit {

  uquizzes: UserQuizzes[] = [];

  errorMessage = '';
  errorMessageSubscription: Subscription;

  constructor(private userquizService: UserquizService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.errorMessageSubscription = this.userquizService.$userQuizErro.subscribe(errorMessage => {
      this.errorMessage = errorMessage;
    });

    this.httpClient.get<UserQuizzes[]>(`http://localhost:8080/QuizApp/userquiz`, {
      withCredentials: true
    }).subscribe(data => {
      console.log(data);
      this.uquizzes = data;
    },
    err => {
      console.log(err);
    });
  }

}
