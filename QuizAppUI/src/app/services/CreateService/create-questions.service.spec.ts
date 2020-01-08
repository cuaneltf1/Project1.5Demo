import { TestBed } from '@angular/core/testing';

import { CreateQuestionsService } from './create-questions.service';

describe('CreateQuestionsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CreateQuestionsService = TestBed.get(CreateQuestionsService);
    expect(service).toBeTruthy();
  });
});
