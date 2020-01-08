import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAwayFromHomeComponent } from './home-away-from-home.component';

describe('HomeAwayFromHomeComponent', () => {
  let component: HomeAwayFromHomeComponent;
  let fixture: ComponentFixture<HomeAwayFromHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeAwayFromHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAwayFromHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
