import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RepairmentsComponent } from './repairments.component';

describe('RepairmentsComponent', () => {
  let component: RepairmentsComponent;
  let fixture: ComponentFixture<RepairmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RepairmentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RepairmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
