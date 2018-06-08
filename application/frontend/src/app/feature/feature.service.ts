import {Injectable} from '@angular/core';
import {HttpClient } from '@angular/common/http';
import {Observable, of} from "rxjs";

import {OefffBackend} from "../oefff.backend";

export interface FeatureService {
    getFeature(projectName: string, epicName: string, featureName: string) : Observable<Feature>;
}


@Injectable()
export class FeatureServiceImpl implements FeatureService {

    constructor(private httpClient: HttpClient, private oefffBackend : OefffBackend) {
    }

    getFeature(projectName: string, epicName: string, featureName: string) {
        let url = this.oefffBackend.URL + "api/projects/" + projectName + "/epics/" + epicName + "/features/" + featureName;

        return this.httpClient.get<Feature>(url)
    }
}

export interface FeatureInfo {
    name: String,
}
export interface Feature {
    name: String,
    description: String,
    children: Scenario[]
}

export interface Step {
    keyword: String,
    text: String,

}

export interface Scenario {
    keyword: String,
    name: String,
    steps: Step[]
}

export class MockFeatureService implements FeatureService {

    constructor(private feature: Feature) {
    }

    getFeature(projectName: string, epicName: string, featureName: string) : Observable<Feature> {
        return of(this.feature);
    }
}
