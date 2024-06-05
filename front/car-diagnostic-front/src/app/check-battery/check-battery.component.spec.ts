import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckBatteryComponent } from './check-battery.component';

describe('CheckBatteryComponent', () => {
  let component: CheckBatteryComponent;
  let fixture: ComponentFixture<CheckBatteryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CheckBatteryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CheckBatteryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
