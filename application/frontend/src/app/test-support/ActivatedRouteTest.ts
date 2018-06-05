import {Subscription} from "rxjs/internal/Subscription";
import {Observable, of} from "rxjs/index";
import {ParamMap} from "@angular/router/src/shared";

export class MockParams implements ParamMap {

    constructor(private parameters: {[key: string]: any}) {
    }

    get params(): MockParams {
        return this;
    }


    readonly keys: string[];

    get(name: string): string | null {
        return this.parameters[name];
    }

    getAll(name: string): string[] {
        return []
    }

    has(name: string): boolean {
        return false;
    }
}

export class MockActivatedRoute {
    constructor(public params: MockParams) {}


    paramMap = of(this.params)


}
