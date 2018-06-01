import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EpicListComponent} from './epic-list.component';
import {EpicService, MockEpicService} from "./epic-service";

describe('EpicListComponent', () => {
  let component: EpicListComponent;
  let fixture: ComponentFixture<EpicListComponent>;


    beforeEach(async(() => {
        let mockEpicService = new MockEpicService();
        TestBed.configureTestingModule({
            declarations: [ EpicListComponent ],
            providers: [
                {
                    provide: EpicService, useValue: mockEpicService
                }
            ]
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
