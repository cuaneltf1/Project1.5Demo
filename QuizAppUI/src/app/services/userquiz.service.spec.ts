import { TestBed } from '@angular/core/testing';

import { UserquizService } from './userquiz.service';

describe('UserquizService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserquizService = TestBed.get(UserquizService);
    expect(service).toBeTruthy();
  });
});
