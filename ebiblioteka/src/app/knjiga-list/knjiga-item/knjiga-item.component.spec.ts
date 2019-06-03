import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KnjigaItemComponent } from './knjiga-item.component';

describe('KnjigaItemComponent', () => {
  let component: KnjigaItemComponent;
  let fixture: ComponentFixture<KnjigaItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KnjigaItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KnjigaItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
