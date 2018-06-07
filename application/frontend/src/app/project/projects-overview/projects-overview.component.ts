import {Component, Inject, OnInit} from '@angular/core';
import {Project, ProjectService} from "../project-service";

@Component({
  selector: 'projects',
  templateUrl: './projects-overview.component.html',
  styleUrls: ['./projects-overview.component.css']
})
export class ProjectsOverviewComponent implements OnInit {

    projects : Project[] = [];
    loading = true;
    canDisplayProjectList = false;

    constructor(@Inject('ProjectService') private projectService: ProjectService) { }


   ngOnInit() {

        this.projectService.getProjects()
            .subscribe(data => {

                this.projects = data;
                this.canDisplayProjectList = this.projects.length > 0;
                this.loading = false;

            })

    }


}


