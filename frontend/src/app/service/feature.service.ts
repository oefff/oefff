import {Injectable} from '@angular/core';
import {HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/of';
import {OefffBackend} from "../oefff.backend";

@Injectable()
export class FeatureService {

    constructor(private httpClient: HttpClient, private oefffBackend : OefffBackend) {
    }

    getFeature(featureName: string) : Observable<Feature> {
        return this.httpClient.get<Feature>(this.oefffBackend.URL + "/api/feature/" + featureName)
    }
}


export interface Feature {
    name: String,
}


export class MockFeatureService {

    constructor(private feature: Feature) {
    }

    getFeature(featureName: string) : Observable<Feature> {
        return Observable.of(this.feature);
    }
}
