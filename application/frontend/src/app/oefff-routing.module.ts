import { NgModule }              from '@angular/core';
import { RouterModule, Routes }  from '@angular/router';
import {ProjectsOverviewComponent} from "./project/projects-overview/projects-overview.component";
import {ProjectDetailComponent} from "./project/project-detail/project-detail.component";
import {FeatureDetailDisplayComponent} from "./feature/display/feature-detail-display.component";

export const appRoutes: Routes = [
    { path: 'projects/:project/:epic/:feature', component: FeatureDetailDisplayComponent },
    { path: 'projects/:id',      component: ProjectDetailComponent },
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
    imports: [
        RouterModule.forRoot(
            appRoutes,
            { enableTracing: false } // <-- debugging purposes only
        )
    ],
    exports: [
        RouterModule
    ]
})
export class OefffRoutingModule {}
