import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';

import {Feature, FeatureService} from './feature.service';


describe('FeatureService', () => {

    let httpClient: HttpClient;
    let httpTestingController: HttpTestingController;

    let featureService: FeatureService;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [FeatureService]
        });

        // Inject the http service and test controller for each test
        httpClient = TestBed.get(HttpClient);
        httpTestingController = TestBed.get(HttpTestingController);
        featureService = TestBed.get(FeatureService)

    });


    it('should cast the response to a Feature', () => {

        const mockFeature: Feature = {name: 'Read a feature from the HTTP Backend'};
        let feature : Feature = {name: ""};


        let featureObservable = featureService.getFeature("http/readFeatureFromServer");
        featureObservable.subscribe(data => feature = data);
        const getRequestForFeature = httpTestingController.expectOne('http://localhost:8080/feature/http/readFeatureFromServer');

        // Assert that the request is a GET.
        expect(getRequestForFeature.request.method).toEqual('GET');
        getRequestForFeature.flush(mockFeature);


        expect(feature.name).toBe("Read a feature from the HTTP Backend");

        httpTestingController.verify();

    });


});
