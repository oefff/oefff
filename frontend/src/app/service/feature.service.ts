import {Injectable} from '@angular/core';
import {HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/of';

@Injectable()
export class FeatureService {

    constructor(private httpClient: HttpClient) {
    }

    getFeature(featureName: string) : Observable<Feature> {
        console.log(featureName);

        return this.httpClient.get<Feature>("http://localhost:8080/feature/" + featureName);

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
