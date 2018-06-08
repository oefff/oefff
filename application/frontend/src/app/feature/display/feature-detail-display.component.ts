import {Component, Inject, OnInit} from '@angular/core';
import {Feature, FeatureService, Scenario} from "../feature.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'feature-detail-display',
  templateUrl: './feature-detail-display.component.html',
  styleUrls: ['./feature-detail-display.component.css']
})
export class FeatureDetailDisplayComponent implements OnInit {

  feature: FeatureWrapper;

  constructor(
      private route: ActivatedRoute,
      @Inject('FeatureService') private featureService: FeatureService) {

  }

  ngOnInit() {

      let featureObserver = this.route.paramMap.pipe(
          switchMap((params: ParamMap) =>
              this.featureService.getFeature(params.get('project'), params.get('epic'), params.get('feature')))
      );
      featureObserver.subscribe(data => this.feature = new FeatureWrapper(data));
  }

}

class FeatureWrapper {

    constructor(private wrapped: Feature) {

    }

    get name(): String {
        return this.wrapped.name;
    }
    get scenarios() : Scenario[] {
      return this.wrapped.children
          .filter(value => value.keyword == "Scenario")
    }
    get description(): String {
        return this.wrapped.description;
    }
    get userStory() : UserStory {
        return new UserStory(this.wrapped.description)
    }

}


export class UserStory {

    purpose : String;
    actor: String;
    action: String;

    constructor(description: String) {
        let parts = description.replace(/\r\n/g, "\r").replace(/\n/g, "\r").split(/\r/);

        this.purpose = asPurpose(parts[0]);
        this.actor = asActor(parts[1]);
        this.action = asAction(parts[2]);
    }


}


const PURPOSE_PREFIX = "In order to";
const ACTOR_PREFIX = "As";
const ACTION_PREFIX = "In want to";

function trimmed(value: string, prefix: string) {
    let trimmedValue = value.trim();

    if (trimmedValue.startsWith(prefix)) {
        return trimmedValue.substr(prefix.length)
    }
    return trimmedValue;
}

function asPurpose(purposePart: string) {
    return trimmed(purposePart, PURPOSE_PREFIX);
}
function asActor(actorPart: string) {
    return trimmed(actorPart, ACTOR_PREFIX);
}
function asAction(actionPart: string) {
    return trimmed(actionPart, ACTION_PREFIX);
}
