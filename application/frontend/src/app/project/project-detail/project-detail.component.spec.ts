import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProjectDetailComponent} from './project-detail.component';
import {RouterTestingModule} from "@angular/router/testing";
import {EpicListComponent} from "../../epic/epic-list.component";
import {MockProjectService} from "../project-service";

describe('ProjectDetailComponent', () => {
  let component: ProjectDetailComponent;
  let fixture: ComponentFixture<ProjectDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectDetailComponent, EpicListComponent ],
        imports: [RouterTestingModule],
        providers: [
            {provide: "ProjectService", useClass: MockProjectService},
        ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be able to be created', () => {
    expect(component).toBeTruthy();
  });
});
