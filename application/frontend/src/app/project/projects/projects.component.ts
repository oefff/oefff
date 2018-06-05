import {Component, Inject, OnInit} from '@angular/core';
import {Project, ProjectService} from "../project-service";

@Component({
  selector: 'projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

    projects : Project[];

    constructor(@Inject('ProjectService') private projectService: ProjectService) { }


    ngOnInit() {
        this.projectService.getProjects()
            .subscribe(data => this.projects = data)

    }
}
