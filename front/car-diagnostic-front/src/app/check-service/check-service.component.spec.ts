import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckServiceComponent } from './check-service.component';

describe('CheckServiceComponent', () => {
  let component: CheckServiceComponent;
  let fixture: ComponentFixture<CheckServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CheckServiceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CheckServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
