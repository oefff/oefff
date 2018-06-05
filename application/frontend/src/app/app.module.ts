import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import { RouterModule, Routes } from '@angular/router';

import {AppComponent} from './app.component';
import {FeatureService, FeatureServiceImpl} from './feature/feature.service';
import {FeatureDetailDisplayComponent} from './feature/feature-detail-display.component';
import {OefffBackend} from "./oefff.backend";
import {EpicListComponent} from './epic/epic-list.component';
import { ProjectDetailComponent } from './project/project-detail/project-detail.component';
import {ProjectServiceImpl} from "./project/project-service";
import {ProjectsOverviewComponent} from "./project/projects-overview/projects-overview.component";


const appRoutes: Routes = [
    { path: 'project/:id',      component: ProjectDetailComponent },
    {
        path: 'projects',
        component: ProjectsOverviewComponent,
        data: { title: 'Projects' }
    },
    { path: '',
        redirectTo: '/projects',
        pathMatch: 'full'
    },
    { path: '**', redirectTo: '/projects' }
];


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
        RouterModule.forRoot(
            appRoutes,
            { enableTracing: false } // <-- debugging purposes: Switch to true
        ),
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
