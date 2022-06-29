import { Risk } from './../../models/risk';
import { RiskService } from './../../service/risk.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-risk',
  templateUrl: './edit-risk.component.html',
  styleUrls: ['./edit-risk.component.css'],
})
export class EditRiskComponent implements OnInit {
  @Input() risk: Risk | undefined;
  occurrence?: string;
  impactValue?: string;
  tags?: string;
  contingenceMails?: string;
  mitigationMails?: string;
  constructor(private service: RiskService) {}

  ngOnInit(): void {}

  editRisk() {
    console.log(this.risk);
  }
}
