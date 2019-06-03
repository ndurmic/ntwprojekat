import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KolekcijaDetailsComponent } from './kolekcija-details.component';

describe('KolekcijaDetailsComponent', () => {
  let component: KolekcijaDetailsComponent;
  let fixture: ComponentFixture<KolekcijaDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KolekcijaDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KolekcijaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
