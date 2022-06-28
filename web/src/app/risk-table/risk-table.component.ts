import { RiskService } from './../service/risk.service';
import { Component, OnInit } from '@angular/core';
import { faArrowUpRightFromSquare, faTrashCan, faEye } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-risk-table',
  templateUrl: './risk-table.component.html',
  styleUrls: ['./risk-table.component.css'],
})
export class RiskTableComponent implements OnInit {
  risks: any;
  constructor(private service: RiskService) {}

  faArrowUpRightFromSquare = faArrowUpRightFromSquare;
  faTrashCan = faTrashCan;
  faEye = faEye;

  ngOnInit(): void {
    this.getRisks();
  }

  getRisks() {
    this.risks = [];
    this.risks = this.service.getAllRisks();
  }
}
