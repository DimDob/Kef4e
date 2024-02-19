import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LikeButtonModalComponent } from './like-button-modal.component';

describe('LikeButtonModalComponent', () => {
  let component: LikeButtonModalComponent;
  let fixture: ComponentFixture<LikeButtonModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LikeButtonModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LikeButtonModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
