import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KolekcijaListComponent } from './kolekcija-list.component';

describe('KolekcijaListComponent', () => {
  let component: KolekcijaListComponent;
  let fixture: ComponentFixture<KolekcijaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KolekcijaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KolekcijaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
