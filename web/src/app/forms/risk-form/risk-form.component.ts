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

  ngOnInit(): void {
    console.log('onInit');
  }

  saveRisk() {
    this.risk.projectId = this.projectId;
    console.log('projectId' + this.risk.projectId);

    if (this.occurrence != undefined) {
      this.risk.probability = Number(this.occurrence);
      console.log(this.risk.probability, this.occurrence);
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
    console.log(this.risk.labels);

    console.log(this.risk.responsibleContingencyMails);
    console.log(this.risk.responsibleMitigationMails);

    console.log('guadando');
    this.service.saveRisk(this.risk).subscribe(() => {
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    });
    this.impactValue = '';
    this.occurrence = '';
  }

  onSubmit() {
    console.log({ risk: this.risk });
    this.risk = this.getEmptyRisk();
  }

  getEmptyRisk(): Risk {
    return {
      id: '',
      projectId: '',
      name: '',
      userId: '',
      labels: [''],
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
