import { RiskService } from './../service/risk.service';
import { Component, Input, OnInit } from '@angular/core';
import { Risk } from '../models/risk';
import { faHeartCirclePlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-risk-table',
  templateUrl: './risk-table.component.html',
  styleUrls: ['./risk-table.component.css'],
})
export class RiskTableComponent implements OnInit {
  faHeartCirclePlus = faHeartCirclePlus;
  @Input() risks?: Risk[];
  constructor(private service: RiskService) {}

  ngOnInit(): void {}

  deleteRisk(risk: Risk) {
    console.log(risk);
  }
}
