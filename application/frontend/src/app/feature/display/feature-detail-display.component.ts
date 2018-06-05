import {Component, Inject, OnInit} from '@angular/core';
import {Feature, FeatureService} from "../feature.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'feature-detail-display',
  templateUrl: './feature-detail-display.component.html',
  styleUrls: ['./feature-detail-display.component.css']
})
export class FeatureDetailDisplayComponent implements OnInit {

  feature: Feature;

  constructor(
      private route: ActivatedRoute,
      @Inject('FeatureService') private featureService: FeatureService) {

  }

  ngOnInit() {

      let featureObserver = this.route.paramMap.pipe(
          switchMap((params: ParamMap) =>
              this.featureService.getFeature(params.get('project'), params.get('epic'), params.get('feature')))
      );
      featureObserver.subscribe(data => this.feature = data);
  }



}
