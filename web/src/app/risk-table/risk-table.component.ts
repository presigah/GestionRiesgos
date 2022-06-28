import { RiskService } from './../service/risk.service';
import { Component, Input, OnInit } from '@angular/core';
import { Risk } from '../models/risk';

@Component({
  selector: 'app-risk-table',
  templateUrl: './risk-table.component.html',
  styleUrls: ['./risk-table.component.css'],
})
export class RiskTableComponent implements OnInit {
  @Input() risks?: Risk[];
  constructor(private service: RiskService) {}

  ngOnInit(): void {}
}
