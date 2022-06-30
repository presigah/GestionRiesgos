import { RiskService } from './../../service/risk.service';
import { Risk } from './../../models/risk';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-risk-form',
  templateUrl: './risk-form.component.html',
  styleUrls: ['./risk-form.component.css'],
})
export class RiskFormComponent implements OnInit {
  @Input() projectId: string | undefined;
  risk: Risk = this.getEmptyRisk();
  occurrence?: string;
  impactValue?: string;
  tags?: string;
  contingenceMails?: string;
  mitigationMails?: string;

  constructor(private service: RiskService) {}

  ngOnInit(): void {}

  saveRisk() {
    this.risk.projectId = this.projectId;
    if (this.occurrence != undefined) {
      this.risk.probability = Number(this.occurrence);
    }
    if (this.impactValue != undefined) {
      this.risk.impactValue = Number(this.impactValue);
    }
    if (this.tags != undefined) {
      this.risk.labels = this.tags.split(',');
    }
    if (this.contingenceMails != undefined) {
      this.risk.responsibleContingencyMails = this.contingenceMails.split(',');
    }
    if (this.mitigationMails != undefined) {
      this.risk.responsibleMitigationMails = this.mitigationMails.split(',');
    }
    this.risk.userId = '11298';

    this.service.saveRisk(this.risk).subscribe(() => {
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    });
    this.impactValue = '';
    this.occurrence = '';
  }

  onSubmit() {
    this.risk = this.getEmptyRisk();
  }

  getEmptyRisk(): Risk {
    return {
      projectId: '',
      name: '',
      userId: '',
      labels: [],
      description: '',
      riskState: '',
      audience: '',
      category: '',
      riskType: '',
      detailsRiskType: '',
      probability: 0,
      impactValue: 0,
      mitigationPlan: '',
      responsibleMitigationMails: [''],
      contingencyPlan: '',
      responsibleContingencyMails: [''],
    };
  }
}
