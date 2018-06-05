import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProjectsOverviewComponent} from './projects-overview.component';
import {MockProjectService, ProjectService} from "../project-service";
import {RouterTestingModule} from "@angular/router/testing";

describe('ProjectsOverviewComponent', () => {
  let component: ProjectsOverviewComponent;
  let fixture: ComponentFixture<ProjectsOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectsOverviewComponent ],
        imports:[RouterTestingModule],
        providers: [{provide: 'ProjectService', useClass: MockProjectService }]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
