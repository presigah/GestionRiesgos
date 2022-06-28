import { RiskService } from './../../service/risk.service';
import { Risk } from './../../models/risk';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-risk-form',
  templateUrl: './risk-form.component.html',
  styleUrls: ['./risk-form.component.css'],
})
export class RiskFormComponent implements OnInit {
  @Input() projectId?: string;
  risk: Risk = {
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

  constructor(private service: RiskService) {}

  ngOnInit(): void {}

  saveRisk(risk: Risk) {
    console.log('nombre' + risk.name);
    this.service.saveRisk(risk).subscribe(() => {
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    });
  }
}
