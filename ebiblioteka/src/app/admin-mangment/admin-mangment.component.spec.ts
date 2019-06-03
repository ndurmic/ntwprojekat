import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMangmentComponent } from './admin-mangment.component';

describe('AdminMangmentComponent', () => {
  let component: AdminMangmentComponent;
  let fixture: ComponentFixture<AdminMangmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMangmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMangmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
