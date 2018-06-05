import {inject, TestBed} from '@angular/core/testing';

import {Epic, EpicService, TEST_EPICS} from './epic-service';
import {HttpClient} from "@angular/common/http";
import {HttpClientTestingModule, HttpTestingController} from "@angular/common/http/testing";
import {OefffBackend} from "../oefff.backend";

describe('EpicService', () => {

    let httpClient: HttpClient;
    let httpTestingController: HttpTestingController;

    let epicService: EpicService;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [EpicService, OefffBackend]
        });

        // Inject the http service and test controller for each test
        httpClient = TestBed.get(HttpClient);
        httpTestingController = TestBed.get(HttpTestingController);
        epicService = TestBed.get(EpicService)

    });




    it('should call the backend and convert response into Epics', inject([EpicService], (service: EpicService) => {

        let epics : Epic[] = [];

        let featureObservable = epicService.getEpics();
        featureObservable.subscribe(data => epics = data);
        const getRequestForFeature = httpTestingController.expectOne('http://localhost:8080/api/projects/oefff/epics');

        // Assert that the request is a GET.
        expect(getRequestForFeature.request.method).toEqual('GET');
        getRequestForFeature.flush(TEST_EPICS);


        expect(epics[0].name).toBe("first");
        expect(epics[1].features[1].name).toBe("TwoBeta");

        httpTestingController.verify();


    }));
});
