import {async, TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {FeatureDetailDisplayComponent} from "./feature/display/feature-detail-display.component";
import {FeatureService, MockFeatureService} from "./feature/feature.service";
import {EpicListComponent} from "./epic/epic-list.component";
import {OefffRoutingModule} from "./oefff-routing.module";
import {ProjectsOverviewComponent} from "./project/projects-overview/projects-overview.component";
import {ProjectDetailComponent} from "./project/project-detail/project-detail.component";
import {RouterTestingModule} from "@angular/router/testing";

describe('AppComponent', () => {
  beforeEach(async(() => {
      const mockFeatureService = new MockFeatureService({name: 'Mocked That Thing', description:'', children: []});

      TestBed.configureTestingModule({
      declarations: [
        AppComponent, FeatureDetailDisplayComponent, EpicListComponent, ProjectsOverviewComponent, ProjectDetailComponent
      ],
          imports:[
             RouterTestingModule
          ],
        providers: [
            { provide: 'FeatureService', useValue: mockFeatureService },

        ],
    }).compileComponents();
  }));


  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));



});
