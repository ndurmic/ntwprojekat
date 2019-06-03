import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KolekcijeComponent } from './kolekcije.component';

describe('KolekcijeComponent', () => {
  let component: KolekcijeComponent;
  let fixture: ComponentFixture<KolekcijeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KolekcijeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KolekcijeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
