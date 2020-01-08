import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizToUserComponent } from './quiz-to-user.component';

describe('QuizToUserComponent', () => {
  let component: QuizToUserComponent;
  let fixture: ComponentFixture<QuizToUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuizToUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizToUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
