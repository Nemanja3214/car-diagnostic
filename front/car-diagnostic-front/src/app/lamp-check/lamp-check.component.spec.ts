import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LampCheckComponent } from './lamp-check.component';

describe('LampCheckComponent', () => {
  let component: LampCheckComponent;
  let fixture: ComponentFixture<LampCheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LampCheckComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LampCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
