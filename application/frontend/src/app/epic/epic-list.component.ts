import {Component, Input, OnInit} from '@angular/core';
import {Epic} from "./epic";

@Component({
  selector: 'epic-list',
  templateUrl: './epic-list.component.html',
  styleUrls: ['./epic-list.component.css']
})
export class EpicListComponent implements OnInit {


  @Input('epics') epics: Epic[];

  constructor() { }


  ngOnInit() {

  }

}
