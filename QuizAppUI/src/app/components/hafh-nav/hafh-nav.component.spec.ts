import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HafhNavComponent } from './hafh-nav.component';

describe('HafhNavComponent', () => {
  let component: HafhNavComponent;
  let fixture: ComponentFixture<HafhNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HafhNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HafhNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
