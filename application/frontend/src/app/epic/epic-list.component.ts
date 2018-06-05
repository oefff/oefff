import {Component, Input, OnInit} from '@angular/core';
import {Epic} from "./epic";
import {Project} from "../project/project-service";

@Component({
  selector: 'epic-list',
  templateUrl: './epic-list.component.html',
  styleUrls: ['./epic-list.component.css']
})
export class EpicListComponent implements OnInit {

  @Input('project') project: Project;
  @Input('epics') epics: Epic[];

  constructor() { }


  ngOnInit() {

  }

}
