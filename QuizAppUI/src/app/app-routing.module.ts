import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { QuizComponent } from './components/Create/quiz/quiz.component';
import { QuestionComponent } from './components/Create/question/question.component';
import { QuestToQuizComponent } from './components/Assign/quest-to-quiz/quest-to-quiz.component';
import { QuizToUserComponent } from './components/Assign/quiz-to-user/quiz-to-user.component';
import { HomeAwayFromHomeComponent } from './components/home-away-from-home/home-away-from-home.component';
import { ViewQuizzesComponent } from './components/view-quizzes/view-quizzes.component';


const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'hafh',
    component: HomeAwayFromHomeComponent
  },
  {
    path: 'vq',
    component: ViewQuizzesComponent
  },
  {
    path: 'quiz',
    component: QuizComponent
  },
  {
    path: 'question',
    component: QuestionComponent
  },
  {
    path: 'qutoq',
    component: QuestToQuizComponent
  },
  {
    path: 'qtou',
    component: QuizToUserComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
