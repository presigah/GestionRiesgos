import { ComponentFixture, TestBed } from '@angular/core/testing';

import { projectFormComponent } from './project-form.component';

describe('projectFormComponent', () => {
  let component: projectFormComponent;
  let fixture: ComponentFixture<projectFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ projectFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(projectFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
