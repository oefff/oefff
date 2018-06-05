import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {OefffBackend} from "../oefff.backend";
import {FeatureInfo} from "../feature/feature.service";
import {EpicInfo} from "../epic/epic-service";

export interface ProjectService {
    getProjects() : Observable<Project[]>
}


@Injectable()
export class ProjectServiceImpl implements ProjectService {

    constructor(private httpClient: HttpClient, private oefffBackend : OefffBackend) {
    }

    getProjects() : Observable<Project[]> {
        return this.httpClient.get<Project[]>(this.oefffBackend.URL + "api/projects");
    }

}


export interface Project {
    name: String,
    epicNames: EpicInfo[],
    featureNames: FeatureInfo[],
}

export class MockProjectService implements ProjectService {
    private : any;

    getProjects() {
        return Observable.of(TEST_PROJECTS);
    }
}



const firstProject: Project = {name: 'oefff', epicNames: [], featureNames: [{name: 'reviewFeature'}, {name: 'configureProject'}]};
const secondProject: Project = {name: 'csvExporter', epicNames: [], featureNames: [{name: 'exportUsers'}, {name: 'exportGroups'}]};
export const TEST_PROJECTS = [firstProject, secondProject];
