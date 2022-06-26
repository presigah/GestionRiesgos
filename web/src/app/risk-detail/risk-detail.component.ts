import { RiskService } from './../service/risk.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-risk-detail',
  templateUrl: './risk-detail.component.html',
  styleUrls: ['./risk-detail.component.css'],
})
export class RiskDetailComponent implements OnInit {
  // risk: Risk[] | undefined;
  risk: any;

  constructor(private service: RiskService) {}

  ngOnInit(): void {
    this.getRiskId('lklewqeqw123');
  }

  getRiskId(id: string) {
    this.risk = this.service.getRisk(id);
    console.log(this.risk);
  }
}
