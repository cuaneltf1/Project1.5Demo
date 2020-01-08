import { TestBed } from '@angular/core/testing';

import { AssignQuizToUserService } from './assign-quiz-to-user.service';

describe('AssignQuizToUserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AssignQuizToUserService = TestBed.get(AssignQuizToUserService);
    expect(service).toBeTruthy();
  });
});
