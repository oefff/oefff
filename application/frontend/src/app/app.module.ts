import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";


import {AppComponent} from './app.component';
import {FeatureService, FeatureServiceImpl} from './service/feature.service';
import {FeatureDetailDisplayComponent} from './feature-detail-display/feature-detail-display.component';
import {OefffBackend} from "./oefff.backend";
import {EpicListComponent} from './epic/epic-list.component';
import {EpicService} from "./epic/epic-service";


@NgModule({
    declarations: [
        AppComponent,
        FeatureDetailDisplayComponent,
        EpicListComponent,
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
    ],
    providers: [
        EpicService,
        {provide: 'FeatureService', useClass: FeatureServiceImpl}
        , OefffBackend],
    bootstrap: [AppComponent]
})
export class AppModule {
}
