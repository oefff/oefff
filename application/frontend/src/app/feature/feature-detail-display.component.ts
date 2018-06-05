import {Component, Inject, OnInit} from '@angular/core';
import {Feature, FeatureService} from "./feature.service";

@Component({
  selector: 'feature-detail-display',
  templateUrl: './feature-detail-display.component.html',
  styleUrls: ['./feature-detail-display.component.css']
})
export class FeatureDetailDisplayComponent implements OnInit {

  feature: Feature;

  constructor(@Inject('FeatureService') private featureService: FeatureService) {

  }

  ngOnInit() {
    this.featureService.getFeature("review" ,"displayFeature")
        .subscribe(data => this.feature = data)
  }

}
