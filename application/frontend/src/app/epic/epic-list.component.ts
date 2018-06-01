import { Component, OnInit } from '@angular/core';
import {Epic, EpicService} from "./epic-service";

@Component({
  selector: 'epic-list',
  templateUrl: './epic-list.component.html',
  styleUrls: ['./epic-list.component.css']
})
export class EpicListComponent implements OnInit {

  epics : Epic[];

  constructor(private epicService: EpicService) { }


  ngOnInit() {
      this.epicService.getEpics()
          .subscribe(data => this.epics = data)

  }

}
