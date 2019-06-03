import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KolekcijaItemComponent } from './kolekcija-item.component';

describe('KolekcijaItemComponent', () => {
  let component: KolekcijaItemComponent;
  let fixture: ComponentFixture<KolekcijaItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KolekcijaItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KolekcijaItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
