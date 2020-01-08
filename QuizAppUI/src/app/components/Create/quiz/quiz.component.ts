import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { CreateQuizService } from 'src/app/services/CreateService/create-quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit, OnDestroy {

  quizzes = {
    quiz_title: '',
    quiz_description: ''
  };

  errorMessage = '';
  errorMessageSubscription: Subscription;

  constructor(private createQuizService: CreateQuizService) { }

  ngOnInit() {
    this.errorMessageSubscription = this.createQuizService.$createQuizError.subscribe(errorMessage => {
      this.errorMessage = errorMessage;
    });
  }

  newQuiz() {
    this.createQuizService.newQuiz(this.quizzes);
  }

  ngOnDestroy() {
    this.errorMessageSubscription.unsubscribe();
  }

}
