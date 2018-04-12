import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";


import { AppComponent } from './app.component';
import { FeatureService } from './service/feature.service';
import { FeatureDetailDisplayComponent } from './feature-detail-display/feature-detail-display.component';


@NgModule({
  declarations: [
    AppComponent, FeatureDetailDisplayComponent
  ],
  imports: [
      BrowserModule,
      HttpClientModule,
  ],
  providers: [FeatureService],
  bootstrap: [AppComponent]
})
export class AppModule { }
