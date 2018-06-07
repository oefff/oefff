import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";

import {AppComponent} from './app.component';
import {FeatureService, FeatureServiceImpl} from './feature/feature.service';
import {FeatureDetailDisplayComponent} from './feature/display/feature-detail-display.component';
import {OefffBackend} from "./oefff.backend";
import {EpicListComponent} from './epic/epic-list.component';
import {ProjectDetailComponent} from './project/project-detail/project-detail.component';
import {ProjectServiceImpl} from "./project/project-service";
import {ProjectsOverviewComponent} from "./project/projects-overview/projects-overview.component";
import {OefffRoutingModule} from "./oefff-routing.module";
import {OefffMaterialModule} from "./oefff-material-module";
import {FlexLayoutModule} from "@angular/flex-layout";


@NgModule({
    declarations: [
        AppComponent,
        FeatureDetailDisplayComponent,
        EpicListComponent,
        ProjectsOverviewComponent,
        ProjectDetailComponent,
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FlexLayoutModule,
        OefffRoutingModule,
        OefffMaterialModule,
    ],
    providers: [
        OefffBackend,
        {provide: 'FeatureService', useClass: FeatureServiceImpl},
        {provide: 'ProjectService', useClass: ProjectServiceImpl},
        ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
