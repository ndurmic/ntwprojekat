import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KnjigaDetailsComponent } from './knjiga-details.component';

describe('KnjigaDetailsComponent', () => {
  let component: KnjigaDetailsComponent;
  let fixture: ComponentFixture<KnjigaDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KnjigaDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KnjigaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
