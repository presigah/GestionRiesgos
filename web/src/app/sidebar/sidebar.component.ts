import { Component, OnInit } from '@angular/core';
import { faUserGear, faUser, faQuestion, faFolderPlus, faHeartCirclePlus, faArrowRightToBracket, faArrowRightFromBracket, faBolt} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  faUserGear = faUserGear;
  faUser = faUser;
  faQuestion = faQuestion;
  faFolderPlus = faFolderPlus;
  faHeartCirclePlus = faHeartCirclePlus;
  faArrowRightToBracket = faArrowRightToBracket;
  faArrowRightFromBracket = faArrowRightFromBracket;
  faBolt = faBolt;


  constructor() { }

  ngOnInit(): void {
  }

}
