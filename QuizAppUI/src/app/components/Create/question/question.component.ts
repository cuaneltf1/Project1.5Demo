import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { CreateQuestionsService } from 'src/app/services/CreateService/create-questions.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit, OnDestroy {

  qas = {
    question_description: '',
    question_response_1: '',
    question_response_2: '',
    question_response_3: '',
    question_response_4: '',
    answer: ''
  };

  errorMessage = '';
  errorMessageSubscription: Subscription;

  constructor(private createQuestionsService: CreateQuestionsService) { }

  ngOnInit() {
    this.errorMessageSubscription = this.createQuestionsService.$questCreationError.subscribe(errorMessage => {
      this.errorMessage = errorMessage;
    });
  }

  newQA() {
    this.createQuestionsService.newQA(this.qas);
  }

  ngOnDestroy() {
    this.errorMessageSubscription.unsubscribe();
  }

}
