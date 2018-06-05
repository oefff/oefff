import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {Project, ProjectService} from "../project-service";

@Component({
  selector: 'project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {

  project : Project;

  constructor(
      private route: ActivatedRoute,
      @Inject("ProjectService") private service: ProjectService
      ) { }

  ngOnInit() {
      let projectObserver = this.route.paramMap.pipe(
          switchMap((params: ParamMap) =>
              this.service.getProject(params.get('id')))

      );
      projectObserver.subscribe(data => this.project = data)
  }

}
