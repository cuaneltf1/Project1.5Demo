import { TestBed } from '@angular/core/testing';

import { AssignQuestToQuizService } from './assign-quest-to-quiz.service';

describe('AssignQuestToQuizService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AssignQuestToQuizService = TestBed.get(AssignQuestToQuizService);
    expect(service).toBeTruthy();
  });
});
