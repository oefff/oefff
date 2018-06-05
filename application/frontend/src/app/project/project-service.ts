import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {OefffBackend} from "../oefff.backend";
import {FeatureInfo} from "../feature/feature.service";
import {Epic} from "../epic/epic";

export interface ProjectService {
    getProjects() : Observable<Project[]>

    getProject(id: string): Observable<Project>;
}


@Injectable()
export class ProjectServiceImpl implements ProjectService {

    constructor(private httpClient: HttpClient, private oefffBackend : OefffBackend) {
    }

    getProjects() : Observable<Project[]> {
        return this.httpClient.get<Project[]>(this.oefffBackend.URL + "api/projects");
    }

    getProject(id: string): Observable<Project> {
        return this.httpClient.get<Project>(this.oefffBackend.URL + "api/projects/" + id);
    }

}


export interface Project {
    name: String,
    epicNames: Epic[],
    featureNames: FeatureInfo[],
}

export class MockProjectService implements ProjectService {
    private : any;

    getProjects() {
        return of(TEST_PROJECTS);
    }

    getProject(id: string): Observable<Project> {
        return of(TEST_PROJECTS.filter((project) => project.name == id)[0]);
    }
}



const firstProject: Project = {name: 'oefff', epicNames: [], featureNames: [{name: 'reviewFeature'}, {name: 'configureProject'}]};
const secondProject: Project = {name: 'csvExporter', epicNames: [], featureNames: [{name: 'exportUsers'}, {name: 'exportGroups'}]};
export const TEST_PROJECTS = [firstProject, secondProject];
