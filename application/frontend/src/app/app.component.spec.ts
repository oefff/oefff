import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import {FeatureDetailDisplayComponent} from "./feature/display/feature-detail-display.component";
import {FeatureService, MockFeatureService} from "./feature/feature.service";
import {EpicListComponent} from "./epic/epic-list.component";

describe('AppComponent', () => {
  beforeEach(async(() => {
      const mockFeatureService = new MockFeatureService({name: 'Mocked That Thing', description:'', children: []});

      TestBed.configureTestingModule({
      declarations: [
        AppComponent, FeatureDetailDisplayComponent, EpicListComponent
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
  it(`should have as title 'Oefff'`, async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('Oefff');
  }));
  it('should render title in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to Oefff!');
  }));
});
