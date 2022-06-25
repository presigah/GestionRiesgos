import { risk } from './../models/risk';
import { RiskService } from './../service/risk.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-risk-table',
  templateUrl: './risk-table.component.html',
  styleUrls: ['./risk-table.component.css'],
})
export class RiskTableComponent implements OnInit {
  risks: any;
  constructor(private service: RiskService) {}

  ngOnInit(): void {
    this.getRisks();
  }

  getRisks() {
    this.risks = [];
    this.risks = this.service.getAll();
  }
}
