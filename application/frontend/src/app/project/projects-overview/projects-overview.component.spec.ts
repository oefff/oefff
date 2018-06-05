import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectsOverviewComponent } from './projects-overview.component';
import {MockProjectService, ProjectService} from "../project-service";

describe('ProjectsOverviewComponent', () => {
  let component: ProjectsOverviewComponent;
  let fixture: ComponentFixture<ProjectsOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectsOverviewComponent ],
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
