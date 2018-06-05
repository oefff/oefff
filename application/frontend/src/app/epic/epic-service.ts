import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Feature} from "../feature/feature.service";
import {Observable, of} from "rxjs";
import {OefffBackend} from "../oefff.backend";

@Injectable()
export class EpicService {

    constructor(private httpClient: HttpClient, private oefffBackend : OefffBackend) {
    }

    getEpics() : Observable<Epic[]> {
        return this.httpClient.get<Epic[]>(this.oefffBackend.URL + "api/projects/oefff/epics");
    }

}

export interface EpicInfo {
    name: String,
}


export interface Epic {
    name: String,
    features: Feature[]
}

export class MockEpicService extends EpicService {

    constructor() {
        super(null, null)
    }
    getEpics() {
        return of(TEST_EPICS);
    }
}



const firstEpic: Epic = {name: 'first', features: [{name: 'OneAlpha'}, {name: 'OneBeta'}]};
const secondEpic: Epic = {name: 'second', features: [{name: 'TwoAlpha'}, {name: 'TwoBeta'}]};
export const TEST_EPICS = [firstEpic, secondEpic];
