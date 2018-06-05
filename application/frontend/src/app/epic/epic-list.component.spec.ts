import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EpicListComponent} from './epic-list.component';
import {RouterTestingModule} from "@angular/router/testing";

describe('EpicListComponent', () => {
  let component: EpicListComponent;
  let fixture: ComponentFixture<EpicListComponent>;


    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ EpicListComponent ],
            imports:[RouterTestingModule]
        })
            .compileComponents();
    }));



  beforeEach(() => {
    fixture = TestBed.createComponent(EpicListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
