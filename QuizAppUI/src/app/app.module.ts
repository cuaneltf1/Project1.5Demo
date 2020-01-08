import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { from } from 'rxjs';
import { HomeComponent } from './components/home/home.component';
import { NavComponent } from './components/nav/nav.component';
import { QuizComponent } from './components/Create/quiz/quiz.component';
import { QuestionComponent } from './components/Create/question/question.component';
import { QuestToQuizComponent } from './components/Assign/quest-to-quiz/quest-to-quiz.component';
import { QuizToUserComponent } from './components/Assign/quiz-to-user/quiz-to-user.component';
import { HomeAwayFromHomeComponent } from './components/home-away-from-home/home-away-from-home.component';
import { HafhNavComponent } from './components/hafh-nav/hafh-nav.component';
import { ViewQuizzesComponent } from './components/view-quizzes/view-quizzes.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    NavComponent,
    QuizComponent,
    QuestionComponent,
    QuestToQuizComponent,
    QuizToUserComponent,
    HomeAwayFromHomeComponent,
    HafhNavComponent,
    ViewQuizzesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
