import {inject, TestBed} from '@angular/core/testing';

import {Project, ProjectService, ProjectServiceImpl, TEST_PROJECTS} from './project-service';
import {HttpClient} from "@angular/common/http";
import {HttpClientTestingModule, HttpTestingController} from "@angular/common/http/testing";
import {OefffBackend} from "../oefff.backend";

describe('ProjectService', () => {

    let httpClient: HttpClient;
    let httpTestingController: HttpTestingController;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [{provide: 'ProjectService', useClass: ProjectServiceImpl }, OefffBackend]
        });

        // Inject the http service and test controller for each test
        httpClient = TestBed.get(HttpClient);
        httpTestingController = TestBed.get(HttpTestingController);

    });




    it('should call the backend and convert response into Projects', inject(['ProjectService'], (projectService: ProjectService) => {

        let projects : Project[] = [];

        let featureObservable = projectService.getProjects();
        featureObservable.subscribe(data => projects = data);
        const getRequestForFeature = httpTestingController.expectOne('http://localhost:8080/api/projects');

        // Assert that the request is a GET.
        expect(getRequestForFeature.request.method).toEqual('GET');
        getRequestForFeature.flush(TEST_PROJECTS);


        expect(projects[0].name).toBe("oefff");
        expect(projects[1].featureNames[1].name).toBe("exportGroups");

        httpTestingController.verify();


    }));
});
