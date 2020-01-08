import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestToQuizComponent } from './quest-to-quiz.component';

describe('QuestToQuizComponent', () => {
  let component: QuestToQuizComponent;
  let fixture: ComponentFixture<QuestToQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuestToQuizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestToQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
